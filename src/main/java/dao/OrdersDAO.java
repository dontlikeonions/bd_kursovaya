package dao;

import models.Order;

import java.sql.*;
import java.util.ArrayList;

public class OrdersDAO {
    private static Connection conn;
    public OrdersDAO(Connection conn) {
        OrdersDAO.conn = conn;
    }

    public static ArrayList<Order> selectAll() {
        ArrayList<Order> orders = new ArrayList<>();

        try {
            PreparedStatement pSt = conn.prepareStatement("select * from \"Orders\"");
            ResultSet res = pSt.executeQuery();

            while (res.next()) {
                Order order = new Order();
                order.setId(res.getInt("order_id"));
                order.setCustomerId(res.getInt("customer_id"));
                order.setDeliveryId(res.getInt("delivery_id"));
                order.setOrderDate(Timestamp.valueOf(res.getString("order_date")));

                orders.add(order);
            }

            res.close();
            pSt.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return orders;
    }

    public static Order get(int id) {
        Order order = null;

        try {
            PreparedStatement pSt = conn.prepareStatement(
                    "select * from \"Orders\" where order_id = ?"
            );

            pSt.setInt(1, id);
            ResultSet res = pSt.executeQuery();

            if (res.next()) {
                order = new Order();
                order.setId(res.getInt("order_id"));
                order.setCustomerId(Integer.parseInt(res.getString("customer_id")));
                String deliveryIdStr = res.getString("delivery_id");
                order.setDeliveryId(Integer.parseInt(deliveryIdStr != null ? deliveryIdStr : "0"));
                order.setOrderDate(Timestamp.valueOf(res.getString("order_date")));
            }

            res.close();
            pSt.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return order;
    }

    public static int insert(Order order) {
        try {
            PreparedStatement pSt = conn.prepareStatement(
                    "insert into \"Orders\" (customer_id, delivery_id, order_date) values(?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS
            );

            pSt.setInt(1, order.getCustomerId());
            pSt.setInt(2, order.getDeliveryId());
            pSt.setTimestamp(3, order.getOrderDate());

            pSt.executeUpdate();
            pSt.close();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return 0;
    }

    public static int update(Order order) {
        try {
            PreparedStatement pSt = conn.prepareStatement(
                    "update \"Orders\" set customer_id = ?, delivery_id = ?, order_date = ? where order_id = ?"
            );

            pSt.setInt(1, order.getCustomerId());
            pSt.setInt(2, order.getDeliveryId());
            pSt.setTimestamp(3, order.getOrderDate());
            pSt.setInt(4, order.getId());

            pSt.executeUpdate();
            pSt.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return 0;
    }

    public static void delete(int id) {
        try {

            PreparedStatement pSt1 = conn.prepareStatement(
                    "delete from \"Deliveries\" where delivery_id in (select delivery_id from \"Orders\" where order_id = ?)"
            );

            PreparedStatement pSt2 = conn.prepareStatement(
                    "delete from \"Orders\" where order_id = ?"
            );

            pSt1.setInt(1, id);
            pSt1.executeUpdate();
            pSt1.close();

            pSt2.setInt(1, id);
            pSt2.executeUpdate();
            pSt2.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}