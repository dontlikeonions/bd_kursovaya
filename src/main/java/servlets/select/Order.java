package servlets.select;

import dao.OrdersDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.util.ArrayList;


@WebServlet("/SelectOrder")
public class Order extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        ArrayList<models.Order> orders = OrdersDAO.selectAll();
        request.setAttribute("orders", orders);

        try {
            getServletContext().getRequestDispatcher("/views/orders/show.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
