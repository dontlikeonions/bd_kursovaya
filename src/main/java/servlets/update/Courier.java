package servlets.update;

import dao.CouriersDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/UpdateCourier")
public class Courier extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));

        models.Courier courier = CouriersDAO.get(id);


        try {
            if (courier == null) {
                getServletContext().getRequestDispatcher("/notFound.jsp").forward(request, response);
            }
            else {
                request.setAttribute("courier", courier);
                getServletContext().getRequestDispatcher("/views/couriers/update.jsp").forward(request, response);
            }
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        models.Courier courier = new models.Courier();

        courier.setId(Integer.parseInt(request.getParameter("id")));
        courier.setfName(request.getParameter("f_name"));
        courier.setlName(request.getParameter("l_name"));
        courier.setPhone(request.getParameter("phone"));
        courier.setLicencePlate(request.getParameter("licence_plate"));

        CouriersDAO.update(courier);

        try {
            response.sendRedirect(request.getContextPath() + "/SelectCourier");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
