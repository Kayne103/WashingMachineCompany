package Company;

import java.sql.*;
import javax.swing.*;

public class Assembles {
    public static void addAssembles(Connection connection,String partID,String productNumber){
        try {
            String query = "insert into Assembles (productNumber,partID) values (?,?)";
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(1, productNumber);
            statement.setString(2, partID);
            statement.execute();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public static void deleteAssemble (Connection connection, String productNumber) {
        try {
            String query = "delete from Assembles where productNumber=?";
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(1, productNumber);
            statement.execute();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public static ResultSet viewAssembles(Connection connection) throws SQLException {
        Statement stmt = connection.createStatement();
        return stmt.executeQuery("select * from Assembles");
    }
}
