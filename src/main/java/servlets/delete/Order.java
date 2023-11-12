package servlets.delete;

import dao.OrdersDAO;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/DeleteOrder")
public class Order extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));


        models.Order order = OrdersDAO.get(id);
        if (order == null) {
            try {
                response.sendRedirect("Error.jsp");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        OrdersDAO.delete(id);

        try {
            response.sendRedirect(request.getContextPath() + "/SelectOrder");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
