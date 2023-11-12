package servlets.insert;

import dao.CustomersDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/InsertCustomer")
public class Customer extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            getServletContext().getRequestDispatcher("/views/customers/insert.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        models.Customer customer = new models.Customer();

        customer.setfName(request.getParameter("f_name"));
        customer.setlName(request.getParameter("l_name"));
        customer.setPhone(request.getParameter("phone"));
        customer.setEmail(request.getParameter("email"));
        customer.setAddress(request.getParameter("address"));

        CustomersDAO.insert(customer);

        try {
            response.sendRedirect(request.getContextPath() + "/SelectCustomer");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
