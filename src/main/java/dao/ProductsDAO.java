package dao;

import models.Product;

import java.sql.*;
import java.util.ArrayList;

public class ProductsDAO {
    private static Connection conn;

    public ProductsDAO(Connection conn) {
        ProductsDAO.conn = conn;
    }

    public static ArrayList<Product> selectAll() {
        ArrayList<Product> products = new ArrayList<>();

        try {
            PreparedStatement pSt = conn.prepareStatement("select * from \"Products\"");
            ResultSet res = pSt.executeQuery();

            while (res.next()) {
                Product product = new Product();
                product.setId(res.getInt("product_id"));
                product.setProductName(res.getString("product_name"));
                product.setDescription(res.getString("description"));
                product.setCost(res.getInt("cost"));

                products.add(product);
            }

            res.close();
            pSt.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return products;
    }


    public static Product get(int id) {
        Product product = null;

        try {
            PreparedStatement pSt = conn.prepareStatement(
                    "select * from \"Products\" where product_id = ?"
            );

            pSt.setInt(1, id);
            ResultSet res = pSt.executeQuery();

            if (res.next()) {
                product = new Product();
                product.setId(res.getInt("product_id"));
                product.setProductName(res.getString("product_name"));
                product.setDescription(res.getString("description"));
                product.setCost(res.getInt("cost"));
            }

            res.close();
            pSt.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return product;
    }

    public static int insert(Product product) {
        try {
            PreparedStatement pSt = conn.prepareStatement(
                    "insert into \"Products\" (product_name, description, cost) values(?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS
            );

            pSt.setString(1, product.getProductName());
            pSt.setString(2, product.getDescription());
            pSt.setInt(3, product.getCost());

            pSt.executeUpdate();
            pSt.close();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return 0;
    }

    public static int update(Product product) {
        try {
            PreparedStatement pSt = conn.prepareStatement(
                    "update \"Products\" set product_name = ?, description = ?, cost = ? where product_id = ?"
            );

            pSt.setString(1, product.getProductName());
            pSt.setString(2, product.getDescription());
            pSt.setInt(3, product.getCost());
            pSt.setInt(4, product.getId());

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
                    "delete from \"Products\" where product_id = ?"
            );

            pSt.setInt(1, id);
            pSt.executeUpdate();
            pSt.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
