package servlets.update;

import dao.ProductsDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/UpdateProduct")
public class Product extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));

        models.Product product = ProductsDAO.get(id);


        try {
            if (product == null) {
                getServletContext().getRequestDispatcher("/notFound.jsp").forward(request, response);
            }
            else {
                request.setAttribute("product", product);
                getServletContext().getRequestDispatcher("/views/products/update.jsp").forward(request, response);
            }
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        models.Product product = new models.Product();

        product.setId(Integer.parseInt(request.getParameter("id")));
        product.setProductName(request.getParameter("product_name"));
        product.setDescription(request.getParameter("description"));
        product.setCost(Integer.parseInt(request.getParameter("cost")));

        ProductsDAO.update(product);

        try {
            response.sendRedirect(request.getContextPath() + "/SelectProduct");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
