package Company;

import java.sql.*;
import javax.swing.JOptionPane;

public class Operator {
    public static void addOperator(Connection connection,String employeeNo,String machineNumber){
        try {
            String query = "insert into Operator (employeeNo,machineNumber) values (?,?)";
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(2, machineNumber);
            statement.setString(1, employeeNo);
            statement.execute();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public static void deleteOperator(Connection connection, String employeeNo) {
        try {
            String query = "delete from Operator where employeeNo=?";
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(1, employeeNo);
            statement.execute();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public static ResultSet viewOperator(Connection connection) throws SQLException {
        Statement stmt = connection.createStatement();
        return stmt.executeQuery("select * from Operator");
    }
}
