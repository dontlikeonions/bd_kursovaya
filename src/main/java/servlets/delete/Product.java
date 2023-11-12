package servlets.delete;

import dao.ProductsDAO;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/DeleteProduct")
public class Product extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));


        models.Product product = ProductsDAO.get(id);
        if (product == null) {
            try {
                response.sendRedirect("Error.jsp");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        ProductsDAO.delete(id);

        try {
            response.sendRedirect(request.getContextPath() + "/SelectProduct");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
