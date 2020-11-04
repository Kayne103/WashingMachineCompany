import javax.swing.*;
import java.sql.*;
import java.sql.Connection;

public class app {
    public static void main(String[] args) throws ClassNotFoundException, UnsupportedLookAndFeelException,
            InstantiationException, IllegalAccessException, SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/WashingMachineCompany";
            String user = "phpmyadmin";
            String password = "KillSwitch[103]";
            Connection connection = DriverManager.getConnection(url,user,password);

            new appGui(connection).setVisible(true);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
    }
}
