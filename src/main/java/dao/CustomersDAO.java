package dao;

import models.Customer;

import java.sql.*;
import java.util.ArrayList;

public class CustomersDAO {
    private static Connection conn;

    public CustomersDAO(Connection conn) {
        CustomersDAO.conn = conn;
    }

    public static ArrayList<Customer> selectAll() {
        ArrayList<Customer> customers = new ArrayList<>();

        try {
            PreparedStatement pSt = conn.prepareStatement("select * from \"Customers\"");
            ResultSet res = pSt.executeQuery();

            while (res.next()) {
                Customer customer = new Customer();
                customer.setId(res.getInt("customer_id"));
                customer.setfName(res.getString("f_name"));
                customer.setlName(res.getString("l_name"));
                customer.setPhone(res.getString("phone"));
                customer.setEmail(res.getString("email"));
                customer.setAddress(res.getString("address"));

                customers.add(customer);
            }

            res.close();
            pSt.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return customers;
    }


    public static Customer get(int id) {
        Customer customer = null;

        try {
            PreparedStatement pSt = conn.prepareStatement(
                    "select * from \"Customers\" where customer_id = ?"
            );

            pSt.setInt(1, id);
            ResultSet res = pSt.executeQuery();

            if (res.next()) {
                customer = new Customer();
                customer.setId(res.getInt("customer_id"));
                customer.setfName(res.getString("f_name"));
                customer.setlName(res.getString("l_name"));
                customer.setPhone(res.getString("phone"));
                customer.setEmail(res.getString("email"));
                customer.setAddress(res.getString("address"));
            }

            res.close();
            pSt.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return customer;
    }

    public static int insert(Customer customer) {
        try {
            PreparedStatement pSt = conn.prepareStatement(
                    "insert into \"Customers\" (f_name, l_name, phone, email, address) values(?, ?, ?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS
            );

            pSt.setString(1, customer.getfName());
            pSt.setString(2, customer.getlName());
            pSt.setString(3, customer.getPhone());
            pSt.setString(4, customer.getEmail());
            pSt.setString(5, customer.getAddress());

            pSt.executeUpdate();
            pSt.close();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return 0;
    }

    public static int update(Customer customer) {
        try {
            PreparedStatement pSt = conn.prepareStatement(
                    "update \"Customers\" set f_name = ?, l_name = ?, phone = ?, email = ?, address = ? where customer_id = ?"
            );

            pSt.setString(1, customer.getfName());
            pSt.setString(2, customer.getlName());
            pSt.setString(3, customer.getPhone());
            pSt.setString(4, customer.getEmail());
            pSt.setString(5, customer.getAddress());
            pSt.setInt(6, customer.getId());

            pSt.executeUpdate();
            pSt.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return 0;
    }

    public static void delete(int id) {
        try {
            PreparedStatement pSt2 = conn.prepareStatement(
                    "delete from \"Customers\" where customer_id = ?"
            );

            pSt2.setInt(1, id);
            pSt2.executeUpdate();
            pSt2.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
