package servlets.insert;

import dao.OrderedProductsDAO;
import models.Order;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


@WebServlet("/InsertOrderedProducts")
public class OrderedProducts extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            getServletContext().getRequestDispatcher("/views/orderedProducts/insert.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        String orderedProductsIdsStr = request.getParameter("orderedProductsIds");
        int orderId = Integer.parseInt(request.getParameter("order_id"));
        String amountStr = request.getParameter("amount");

        List<String> orderedProductsIds = new ArrayList<String>(Arrays.asList(orderedProductsIdsStr.split(",")));
        List<String> amountLstStr = new ArrayList<String>(Arrays.asList(amountStr.split(",")));

        List<Integer> orderedProductsIdsInt = orderedProductsIds.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> amountLstInt = amountLstStr.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        for (int i = 0; i < orderedProductsIdsInt.size(); i++) {
            models.OrderedProduct orderedProduct = new models.OrderedProduct();
            orderedProduct.setOrderId(orderId);
            orderedProduct.setProductId(orderedProductsIdsInt.get(i));
            orderedProduct.setAmount(amountLstInt.get(i));

            OrderedProductsDAO.insert(orderedProduct);
        }


        try {
            response.sendRedirect(request.getContextPath() + "/SelectOrderedProducts");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
