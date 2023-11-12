package servlets.delete;

import dao.DeliveriesDAO;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/DeleteDelivery")
public class Delivery extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));


        models.Delivery delivery = DeliveriesDAO.get(id);
        if (delivery == null) {
            try {
                response.sendRedirect("Error.jsp");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        DeliveriesDAO.delete(id);

        try {
            response.sendRedirect(request.getContextPath() + "/SelectDelivery");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
