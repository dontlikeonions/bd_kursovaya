package dao;

import models.Courier;

import java.sql.*;
import java.util.ArrayList;

public class CouriersDAO {
    private static Connection conn;
    public CouriersDAO(Connection conn) {
        CouriersDAO.conn = conn;
    }

    public static ArrayList<Courier> selectAll() {
        ArrayList<Courier> couriers = new ArrayList<>();

        try {
            PreparedStatement pSt = conn.prepareStatement("select * from \"Couriers\"");
            ResultSet res = pSt.executeQuery();

            while (res.next()) {
                Courier courier = new Courier();
                courier.setId(res.getInt("courier_id"));
                courier.setfName(res.getString("f_name"));
                courier.setlName(res.getString("l_name"));
                courier.setPhone(res.getString("phone"));
                courier.setLicencePlate(res.getString("licence_plate"));

                couriers.add(courier);
            }

            res.close();
            pSt.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return couriers;
    }

    public static Courier get(int id) {
        Courier courier = null;

        try {
            PreparedStatement pSt = conn.prepareStatement(
                    "select * from \"Couriers\" where courier_id = ?"
            );

            pSt.setInt(1, id);
            ResultSet res = pSt.executeQuery();

            if (res.next()) {
                courier = new Courier();
                courier.setId(res.getInt("courier_id"));
                courier.setfName(res.getString("f_name"));
                courier.setlName(res.getString("l_name"));
                courier.setPhone(res.getString("phone"));
                courier.setLicencePlate(res.getString("licence_plate"));
            }

            res.close();
            pSt.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return courier;
    }

    public static int insert(Courier courier) {
        try {
            PreparedStatement pSt = conn.prepareStatement(
                    "insert into \"Couriers\" (f_name, l_name, phone, licence_plate) values(?, ?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS
            );

            pSt.setString(1, courier.getfName());
            pSt.setString(2, courier.getlName());
            pSt.setString(3, courier.getPhone());
            pSt.setString(4, courier.getLicencePlate());

            pSt.executeUpdate();
            pSt.close();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return 0;
    }

    public static int update(Courier courier) {
        try {
            PreparedStatement pSt = conn.prepareStatement(
                    "update \"Couriers\" set f_name = ?, l_name = ?, phone = ?, licence_plate = ? where courier_id = ?"
            );

            pSt.setString(1, courier.getfName());
            pSt.setString(2, courier.getlName());
            pSt.setString(3, courier.getPhone());
            pSt.setString(4, courier.getLicencePlate());
            pSt.setInt(5, courier.getId());

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
                    "delete from \"Couriers\" where courier_id = ?"
            );

            pSt.setInt(1, id);
            pSt.executeUpdate();
            pSt.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}