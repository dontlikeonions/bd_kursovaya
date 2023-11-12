package listeners;

import dao.*;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Listener implements ServletContextListener {
    final String URL = "jdbc:postgresql://localhost:5433/ozonberries";
    final String USER = "postgres";
    final String PWD = "admin";
    public final static String DRIVER = "org.postgresql.Driver";

    @Override
    public void contextInitialized(ServletContextEvent event) {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USER, PWD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        CouriersDAO couriersDAO = new CouriersDAO(conn);
        CustomersDAO customerDAO = new CustomersDAO(conn);
        ProductsDAO productsDAO = new ProductsDAO(conn);
        DeliveriesDAO deliveriesDAO = new DeliveriesDAO(conn);
        OrdersDAO ordersDAO = new OrdersDAO(conn);
        OrderedProductsDAO orderedProductsDAO = new OrderedProductsDAO(conn);
        MainPageLeftTableDAO mainPageLeftTableDAO = new MainPageLeftTableDAO(conn);
        MainPageRightTableDAO mainPageRightTableDAO = new MainPageRightTableDAO(conn);
    }
}
