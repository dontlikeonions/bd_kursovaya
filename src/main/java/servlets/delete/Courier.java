package servlets.delete;

import dao.CouriersDAO;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/DeleteCourier")
public class Courier extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));


        models.Courier courier = CouriersDAO.get(id);
        if (courier == null) {
            try {
                response.sendRedirect("Error.jsp");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        CouriersDAO.delete(id);

        try {
            response.sendRedirect(request.getContextPath() + "/SelectCourier");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
