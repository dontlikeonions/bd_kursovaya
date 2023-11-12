package servlets.select;

import dao.OrderedProductsDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.util.ArrayList;


@WebServlet("/SelectOrderedProducts")
public class OrderedProducts extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        ArrayList<models.OrderedProduct> orderedProducts = OrderedProductsDAO.selectAll();
        request.setAttribute("orderedProducts", orderedProducts);

        try {
            getServletContext().getRequestDispatcher("/views/orderedProducts/show.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
