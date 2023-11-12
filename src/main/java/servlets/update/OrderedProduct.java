package servlets.update;

import dao.OrderedProductsDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/UpdateOrderedProduct")
public class OrderedProduct extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        int orderId = Integer.parseInt(request.getParameter("order_id"));
        int oldProductId = Integer.parseInt(request.getParameter("oldProductId"));

        models.OrderedProduct orderedProduct = OrderedProductsDAO.get(orderId, oldProductId);


        try {
            if (orderedProduct == null) {
                getServletContext().getRequestDispatcher("/notFound.jsp").forward(request, response);
            }
            else {
                request.setAttribute("orderedProduct", orderedProduct);
                getServletContext().getRequestDispatcher("/views/orderedProducts/update.jsp").forward(request, response);
            }
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        models.OrderedProduct orderedProduct = new models.OrderedProduct();

        orderedProduct.setOrderId(Integer.parseInt(request.getParameter("order_id")));
        orderedProduct.setProductId(Integer.parseInt(request.getParameter("product_id")));
        orderedProduct.setAmount(Integer.parseInt(request.getParameter("amount")));

        OrderedProductsDAO.update(orderedProduct, Integer.parseInt(request.getParameter("oldProductId")));

        try {
            response.sendRedirect(request.getContextPath() + "/SelectOrderedProducts");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
