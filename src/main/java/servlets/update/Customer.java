package servlets.update;

import dao.CustomersDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/UpdateCustomer")
public class Customer extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));

        models.Customer customer = CustomersDAO.get(id);


        try {
            if (customer == null) {
                getServletContext().getRequestDispatcher("/notFound.jsp").forward(request, response);
            }
            else {
                request.setAttribute("customer", customer);
                getServletContext().getRequestDispatcher("/views/customers/update.jsp").forward(request, response);
            }
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        models.Customer customer = new models.Customer();

        customer.setId(Integer.parseInt(request.getParameter("id")));
        customer.setfName(request.getParameter("f_name"));
        customer.setlName(request.getParameter("l_name"));
        customer.setPhone(request.getParameter("phone"));
        customer.setEmail(request.getParameter("email"));
        customer.setAddress(request.getParameter("address"));

        CustomersDAO.update(customer);

        try {
            response.sendRedirect(request.getContextPath() + "/SelectCustomer");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
