package Customer;

import java.sql.*;
import javax.swing.*;

public class orders {

    public static void addOrder(Connection connection,String productNumber,String customerID,int quantity){
        try {
            String query = "insert into Orders(productNumber,customerID,Quantity) VALUES(?,?,?)";
            PreparedStatement stmt = connection.prepareStatement(query);

            stmt.setString(1, productNumber);
            stmt.setString(2, customerID);
            stmt.setInt(3, quantity);

            stmt.execute();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }

    public static void deleteOrder (Connection connection, String productNumber) {
        try {
            String query = "delete from Orders where productNumber=?";
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(1, productNumber);
            statement.execute();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public static ResultSet viewOrders(Connection connection) throws SQLException {
        Statement stmt = connection.createStatement();
        return stmt.executeQuery("select * from Orders");
    }
}
