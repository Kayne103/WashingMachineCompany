import javax.swing.*;
import java.sql.*;
import java.sql.Connection;

public class app {
    public static void main(String[] args) throws ClassNotFoundException, UnsupportedLookAndFeelException,
            InstantiationException, IllegalAccessException, SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //Class.forName("oracle.jdbc.driver.OracleDriver");
            String url = "jdbc:mysql://localhost:3306/WashingMachineCompany";
            String user = "phpmyadmin";
            String password = "KillSwitch[103]";
            Connection connection = DriverManager.getConnection(url,user,password);
            //Connection connection=DriverManager.getConnection(
              //      "jdbc:oracle:thin:@10.0.18.2:1521:orcl","teb01145","teb01145");

            new appGui(connection).setVisible(true);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
    }
}
