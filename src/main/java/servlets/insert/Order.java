package servlets.insert;

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


@WebServlet("/InsertOrder")
public class Order extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            getServletContext().getRequestDispatcher("/views/orders/insert.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        models.Order order = new models.Order();

        order.setCustomerId(Integer.parseInt(request.getParameter("customer_id")));
        order.setDeliveryId(Integer.parseInt(request.getParameter("delivery_id")));

        String dateFromHtml = request.getParameter("order_date").replace("T", " ");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime dateTime = LocalDateTime.parse(dateFromHtml, formatter);

        order.setOrderDate(Timestamp.valueOf(dateTime));

        OrdersDAO.insert(order);

        try {
            response.sendRedirect(request.getContextPath() + "/SelectOrder");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
