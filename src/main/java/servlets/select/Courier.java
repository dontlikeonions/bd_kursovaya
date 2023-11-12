package servlets.select;

import dao.CouriersDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.util.ArrayList;


@WebServlet("/SelectCourier")
public class Courier extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        ArrayList<models.Courier> couriers = CouriersDAO.selectAll();
        request.setAttribute("couriers", couriers);

        try {
            getServletContext().getRequestDispatcher("/views/couriers/show.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
