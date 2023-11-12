package servlets.delete;

import dao.OrderedProductsDAO;
import dao.OrdersDAO;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/DeleteOrderedProduct")
public class OrderedProduct extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        int orderId = Integer.parseInt(request.getParameter("order_id"));
        int productId = Integer.parseInt(request.getParameter("product_id"));


        models.OrderedProduct orderedProduct = OrderedProductsDAO.get(orderId, productId);
        if (orderedProduct == null) {
            try {
                response.sendRedirect("Error.jsp");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        OrderedProductsDAO.delete(orderId, productId);

        try {
            response.sendRedirect(request.getContextPath() + "/SelectOrderedProducts");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
