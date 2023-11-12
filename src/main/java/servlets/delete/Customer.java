package servlets.delete;

import dao.CustomersDAO;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/DeleteCustomer")
public class Customer extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));


        models.Customer customer = CustomersDAO.get(id);
        if (customer == null) {
            try {
                response.sendRedirect("Error.jsp");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        CustomersDAO.delete(id);

        try {
            response.sendRedirect(request.getContextPath() + "/SelectCustomer");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
