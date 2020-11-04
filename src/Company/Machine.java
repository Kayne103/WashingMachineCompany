package Company;

import javax.swing.*;
import java.sql.*;

public class Machine {
    public static void addMachine(Connection connection, String machineNo, String machineName, String section) {
        try {
            String query = "insert into Machine(machineNo,machineName,section) VALUES(?,?,?)";
            PreparedStatement stmt = connection.prepareStatement(query);

            stmt.setString(1, machineNo);
            stmt.setString(2, machineName);
            stmt.setString(3, section);

            stmt.execute();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public static void deleteMachine(Connection connection, String machineNo) {
        try {
            String query = "delete from Machine where machineNo=?";
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(1, machineNo);
            statement.execute();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public static ResultSet viewMachines(Connection connection) throws SQLException {
            Statement stmt = connection.createStatement();
            return stmt.executeQuery("select * from Machine");
    }
}
