package Company;

import javax.swing.*;
import java.sql.*;

public class Product extends JFrame {

    public static void addProduct(Connection connection, String productNumber, String productName, Double productCost,
            String companyName) {
        try {
            String query = "insert into Product(productNumber,productName,productCost,companyName) VALUES(?,?,?,?)";
            PreparedStatement stmt = connection.prepareStatement(query);

            stmt.setString(1, productNumber);
            stmt.setString(2, productName);
            stmt.setDouble(3, productCost);
            stmt.setString(4, companyName);

            stmt.execute();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public static void deleteProduct(Connection connection, String productNumber) {
        try {
            String query = "delete from Products where productNumber=?";
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(1, productNumber);
            statement.execute();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public static ResultSet viewProducts(Connection connection) throws SQLException {
            Statement stmt = connection.createStatement();
            return stmt.executeQuery("select * from Product");
    }

}