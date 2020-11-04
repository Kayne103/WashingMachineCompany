package Company;

import javax.swing.*;
import java.sql.*;

public class Part {
    public static void addPart(Connection connection, String partID, String partName, Double cost) {
        try {
            String query = "insert into Part(partID,partName,cost) VALUES(?,?,?)";
            PreparedStatement stmt = connection.prepareStatement(query);

            stmt.setString(1, partID);
            stmt.setString(2, partName);
            stmt.setDouble(3, cost);

            stmt.execute();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public static void deletePart(Connection connection, String partID) {
        try {
            String query = "delete from Part where partID=?";
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(1, partID);
            statement.execute();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public static ResultSet viewParts (Connection connection) throws SQLException {
            Statement stmt = connection.createStatement();
            return stmt.executeQuery("select * from Part");
    }
}
