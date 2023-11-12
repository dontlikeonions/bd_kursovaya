package dao;

import models.MainPageLeftTable;

import java.sql.*;
import java.util.ArrayList;

public class MainPageLeftTableDAO {
    private static Connection conn;
    public MainPageLeftTableDAO(Connection conn) {
        MainPageLeftTableDAO.conn = conn;
    }


    public static ArrayList<MainPageLeftTable> selectAll() {
        ArrayList<MainPageLeftTable> entries = new ArrayList<>();

        try {
            PreparedStatement pSt = conn.prepareStatement("select \"Customers\".customer_id, \"Customers\".f_name, " +
                    "\"Customers\".l_name, order_date, delivery_date, status, \"Couriers\".phone from \"Customers\" " +
                    "inner join \"Deliveries\" on \"Customers\".customer_id = \"Deliveries\".customer_id " +
                    "inner join \"Orders\" on \"Orders\".delivery_id = \"Deliveries\".delivery_id " +
                    "inner join \"Couriers\" on \"Deliveries\".courier_id = \"Couriers\".courier_id");
            ResultSet res = pSt.executeQuery();

            while (res.next()) {
                MainPageLeftTable entry = new MainPageLeftTable();
                entry.setCustomerId(res.getInt("customer_id"));
                entry.setfName(res.getString("f_name"));
                entry.setlName(res.getString("l_name"));
                entry.setOrderDate(res.getTimestamp("order_date"));
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