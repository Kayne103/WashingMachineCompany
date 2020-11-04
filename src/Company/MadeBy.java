package Company;

import java.sql.*;
import javax.swing.JOptionPane;

public class MadeBy {
    public static void addMadeBy(Connection connection,String partID,String employeeNo){
        try {
            String query = "insert into MadeBy (partID,employeeNo) values (?,?)";
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(2, employeeNo);
            statement.setString(1, partID);
            statement.execute();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public static void deleteMadeBy(Connection connection, String partID) {
        try {
            String query = "delete from MadeBy where partID=?";
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(1, partID);
            statement.execute();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public static ResultSet viewMadeBy(Connection connection) throws SQLException {
        Statement stmt = connection.createStatement();
        return stmt.executeQuery("select * from MadeBy");
    }
}
