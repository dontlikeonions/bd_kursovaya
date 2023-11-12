package dao;

import models.Delivery;

import java.sql.*;
import java.util.ArrayList;

public class DeliveriesDAO {
    private static Connection conn;
    public DeliveriesDAO(Connection conn) {
        DeliveriesDAO.conn = conn;
    }

    public static ArrayList<Delivery> selectAll() {
        ArrayList<Delivery> deliveries = new ArrayList<>();

        try {
            PreparedStatement pSt = conn.prepareStatement("select * from \"Deliveries\"");
            ResultSet res = pSt.executeQuery();

            while (res.next()) {
                Delivery delivery = new Delivery();
                delivery.setId(res.getInt("delivery_id"));
                delivery.setCourierId(res.getInt("courier_id"));
                delivery.setCustomerId(res.getInt("customer_id"));
                delivery.setDeliveryDate(res.getTimestamp("delivery_date"));
                delivery.setStatus(res.getString("status"));

                deliveries.add(delivery);
            }

            res.close();
            pSt.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return deliveries;
    }

    public static Delivery get(int id) {
        Delivery delivery = null;

        try {
            PreparedStatement pSt = conn.prepareStatement(
                    "select * from \"Deliveries\" where delivery_id = ?"
            );

            pSt.setInt(1, id);
            ResultSet res = pSt.executeQuery();

            if (res.next()) {
                delivery = new Delivery();
                delivery.setId(res.getInt("delivery_id"));
                delivery.setCourierId(res.getInt("courier_id"));
                delivery.setCustomerId(res.getInt("customer_id"));
                delivery.setDeliveryDate(res.getTimestamp("delivery_date"));
                delivery.setStatus(res.getString("status"));
            }

            res.close();
            pSt.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return delivery;
    }

    public static int insert(Delivery delivery) {
        try {
            PreparedStatement pSt = conn.prepareStatement(
                    "insert into \"Deliveries\" (courier_id, customer_id, delivery_date, status) values(?, ?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS
            );

            pSt.setInt(1, delivery.getCourierId());
            pSt.setInt(2, delivery.getCustomerId());
            pSt.setTimestamp(3, delivery.getDeliveryDate());
            pSt.setString(4, delivery.getStatus());

            pSt.executeUpdate();
            pSt.close();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return 0;
    }

    public static int update(Delivery delivery) {
        try {
            PreparedStatement pSt = conn.prepareStatement(
                    "update \"Deliveries\" set courier_id = ?, customer_id = ?, delivery_date = ?, status = ? where delivery_id = ?"
            );

            pSt.setInt(1, delivery.getCourierId());
            pSt.setInt(2, delivery.getCustomerId());
            pSt.setTimestamp(3, delivery.getDeliveryDate());
            pSt.setString(4, delivery.getStatus());
            pSt.setInt(5, delivery.getId());

            pSt.executeUpdate();
            pSt.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return 0;
    }

    public static void delete(int id) {
        try {
            PreparedStatement pSt = conn.prepareStatement(
                    "delete from \"Deliveries\" where delivery_id = ?"
            );

            pSt.setInt(1, id);
            pSt.executeUpdate();
            pSt.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}