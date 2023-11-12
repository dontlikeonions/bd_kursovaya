package servlets.insert;

import dao.ProductsDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/InsertProduct")
public class Product extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            getServletContext().getRequestDispatcher("/views/products/insert.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        models.Product product = new models.Product();

        product.setProductName(request.getParameter("product_name"));
        product.setDescription(request.getParameter("description"));

        ProductsDAO.insert(product);

        try {
            response.sendRedirect(request.getContextPath() + "/SelectProduct");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
