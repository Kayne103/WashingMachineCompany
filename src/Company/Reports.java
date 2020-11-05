package Company;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Reports {

    public static void searchForCustomer(Connection connection,String productNumber) throws SQLException {
        try {
            String query = "SELECT * FROM Customer";
            PreparedStatement stmt = connection.prepareStatement(query);
            //stmt.setString(1, productNumber);
            ResultSet resultSet = stmt.executeQuery(query);
            JTable table = new JTable();
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
            JOptionPane.showMessageDialog(null,new JScrollPane(table));
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }

    public static void searchForEmployee(Connection connection,String productNumber){

    }


}
