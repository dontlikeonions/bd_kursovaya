package servlets.select;

import dao.CustomersDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.util.ArrayList;


@WebServlet("/SelectCustomer")
public class Customer extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        ArrayList<models.Customer> customers = CustomersDAO.selectAll();
        request.setAttribute("customers", customers);

        try {
            getServletContext().getRequestDispatcher("/views/customers/show.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
