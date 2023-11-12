package dao;

import models.MainPageRightTable;

import java.sql.*;
import java.util.ArrayList;

public class MainPageRightTableDAO {
    private static Connection conn;

    public MainPageRightTableDAO(Connection conn) {
        MainPageRightTableDAO.conn = conn;
    }


    public static ArrayList<MainPageRightTable> selectAll() {
        ArrayList<MainPageRightTable> entries = new ArrayList<>();

        try {
            PreparedStatement pSt = conn.prepareStatement(
                    "select \"Couriers\".courier_id, \"Couriers\".f_name, \"Couriers\".l_name, \"Deliveries\".delivery_id, order_id, delivery_date, status, \"Customers\".phone from \"Couriers\" " +
                            "inner join \"Deliveries\" on \"Couriers\".courier_id = \"Deliveries\".courier_id " +
                            "inner join \"Orders\" on \"Deliveries\".delivery_id = \"Orders\".delivery_id " +
                            "inner join \"Customers\" on \"Orders\".customer_id = \"Customers\".customer_id"
            );
            ResultSet res = pSt.executeQuery();

            while (res.next()) {
                MainPageRightTable entry = new MainPageRightTable();
                entry.setCourierId(res.getInt("courier_id"));
                entry.setfName(res.getString("f_name"));
                entry.setlName(res.getString("l_name"));
                entry.setDeliveryId(res.getInt("delivery_id"));
                entry.setOrderId(res.getInt("order_id"));
                entry.setDeliveryDate(res.getTimestamp("delivery_date"));
                entry.setStatus(res.getString("status"));
                entry.setPhone(res.getString("phone"));

                entries.add(entry);
            }

            res.close();
            pSt.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return entries;
    }
}