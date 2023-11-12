package servlets.update;

import dao.DeliveriesDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@WebServlet("/UpdateDelivery")
public class Delivery extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));

        models.Delivery delivery = DeliveriesDAO.get(id);


        try {
            if (delivery == null) {
                getServletContext().getRequestDispatcher("/notFound.jsp").forward(request, response);
            }
            else {
                request.setAttribute("delivery", delivery);
                getServletContext().getRequestDispatcher("/views/deliveries/update.jsp").forward(request, response);
            }
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        models.Delivery delivery = new models.Delivery();

        delivery.setId(Integer.parseInt(request.getParameter("id")));
        delivery.setCourierId(Integer.parseInt(request.getParameter("courier_id")));

        String dateFromHtml = request.getParameter("delivery_date").replace("T", " ");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime dateTime = LocalDateTime.parse(dateFromHtml, formatter);

        delivery.setDeliveryDate(Timestamp.valueOf(dateTime));
        delivery.setStatus(request.getParameter("status"));

        DeliveriesDAO.update(delivery);

        try {
            response.sendRedirect(request.getContextPath() + "/SelectDelivery");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
