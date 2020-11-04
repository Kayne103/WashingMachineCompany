package Company;

import java.sql.*;
import javax.swing.JOptionPane;

public class MadeON {
    public static void addMadeON(Connection connection,String partID,String machineNumber){
        try {
            String query = "insert into MadeON (machineNumber,partID) values (?,?)";
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(1, machineNumber);
            statement.setString(2, partID);
            statement.execute();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public static void deleteMadeON(Connection connection, String machineNumber) {
        try {
            String query = "delete from MadeON where machineNumber=?";
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(1, machineNumber);
            statement.execute();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public static ResultSet viewMadeON(Connection connection) throws SQLException {
        Statement stmt = connection.createStatement();
        return stmt.executeQuery("select * from MadeON");
    }
}
