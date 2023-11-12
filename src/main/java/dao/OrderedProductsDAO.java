package dao;

import models.Order;
import models.OrderedProduct;

import java.sql.*;
import java.util.ArrayList;

public class OrderedProductsDAO {
    private static Connection conn;
    public OrderedProductsDAO(Connection conn) {
        OrderedProductsDAO.conn = conn;
    }

    public static ArrayList<OrderedProduct> selectAll() {
        ArrayList<OrderedProduct> orderedProducts = new ArrayList<>();

        try {
            PreparedStatement pSt = conn.prepareStatement("select * from \"Ordered_products\"");
            ResultSet res = pSt.executeQuery();

            while (res.next()) {
                OrderedProduct orderedProduct = new OrderedProduct();
                orderedProduct.setOrderId(res.getInt("order_id"));
                orderedProduct.setProductId(res.getInt("product_id"));
                orderedProduct.setAmount(res.getInt("amount"));

                orderedProducts.add(orderedProduct);
            }

            res.close();
            pSt.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return orderedProducts;
    }

    public static OrderedProduct get(int orderId, int productId) {
        OrderedProduct orderedProduct = null;

        try {
            PreparedStatement pSt = conn.prepareStatement(
                    "select * from \"Ordered_products\" where order_id = ? and product_id = ?"
            );

            pSt.setInt(1, orderId);
            pSt.setInt(2, productId);
            ResultSet res = pSt.executeQuery();

            if (res.next()) {
                orderedProduct = new OrderedProduct();
                orderedProduct.setOrderId(res.getInt("order_id"));
                orderedProduct.setProductId(res.getInt("product_id"));
                orderedProduct.setAmount(res.getInt("amount"));
            }

            res.close();
            pSt.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return orderedProduct;
    }

    public static int insert(OrderedProduct orderedProduct) {
        try {
            PreparedStatement pSt = conn.prepareStatement(
                    "insert into \"Ordered_products\" (order_id, product_id, amount) values(?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS
            );

            pSt.setInt(1, orderedProduct.getOrderId());
            pSt.setInt(2, orderedProduct.getProductId());
            pSt.setInt(3, orderedProduct.getAmount());

            pSt.executeUpdate();
            pSt.close();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return 0;
    }

    public static int update(OrderedProduct orderedProduct, int oldProductId) {
        try {
            PreparedStatement pSt = conn.prepareStatement(
                    "update \"Ordered_products\" set product_id = ?, amount = ? where order_id = ? and product_id = ?"
            );

            pSt.setInt(1, orderedProduct.getProductId());
            pSt.setInt(2, orderedProduct.getAmount());
            pSt.setInt(3, orderedProduct.getOrderId());
            pSt.setInt(4, oldProductId);

            pSt.executeUpdate();
            pSt.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return 0;
    }

    public static void delete(int orderId, int productId) {
        try {
            PreparedStatement pSt = conn.prepareStatement(
                    "delete from \"Ordered_products\" where order_id = ? and product_id = ?"
            );

            pSt.setInt(1, orderId);
            pSt.setInt(2, productId);
            pSt.executeUpdate();
            pSt.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}