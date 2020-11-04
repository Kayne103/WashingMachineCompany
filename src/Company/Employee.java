package Company;

import java.sql.*;
import javax.swing.*;

public class Employee {
    public static void addEmployee(Connection connection, String employeeNo, String ename, Double salary,
            String position) {
        try {
            String query = "insert into Employee(employeeNo,ename,salary,position) VALUES(?,?,?,?)";
            PreparedStatement stmt = connection.prepareStatement(query);

            stmt.setString(1, employeeNo);
            stmt.setString(2, ename);
            stmt.setDouble(3, salary);
            stmt.setString(4, position);

            stmt.execute();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public static void deleteEmployee(Connection connection, String employeeNo) {
        try {
            String query = "delete from Employee where employeeNo=?";
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(1, employeeNo);
            statement.execute();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public static ResultSet viewEmployees(Connection connection) throws SQLException {
            Statement stmt = connection.createStatement();
            return stmt.executeQuery("select * from Employees");
    }
}
