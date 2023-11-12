package servlets.update;

import dao.OrdersDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@WebServlet("/UpdateOrder")
public class Order extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));

        models.Order order = OrdersDAO.get(id);


        try {
            if (order == null) {
                getServletContext().getRequestDispatcher("/notFound.jsp").forward(request, response);
            }
            else {
                request.setAttribute("order", order);
                getServletContext().getRequestDispatcher("/views/orders/update.jsp").forward(request, response);
            }
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        models.Order order = new models.Order();

        order.setId(Integer.parseInt(request.getParameter("id")));
        order.setCustomerId(Integer.parseInt(request.getParameter("customer_id")));
        order.setDeliveryId(Integer.parseInt(request.getParameter("delivery_id")));

        String dateFromHtml = request.getParameter("order_date").replace("T", " ");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime dateTime = LocalDateTime.parse(dateFromHtml, formatter);

        order.setOrderDate(Timestamp.valueOf(dateTime));

        OrdersDAO.update(order);

        try {
            response.sendRedirect(request.getContextPath() + "/SelectOrder");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
