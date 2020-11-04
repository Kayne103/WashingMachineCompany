package Customer;

import javax.swing.*;
import java.sql.*;

public class customer {
    /**
     * Adds data to Customer table.
     *
     * @param conn            Database Connection
     * @param customerID      Customer Identity Number
     * @param customerName    Customer Name
     * @param customerAddress Customer Physical Address
     */
    public static void addCustomer(Connection conn, int customerID, String customerName, String customerAddress) {
        try {
            String query = "insert into Customer(CustomerID,CustomerName,CustomerAddress) VALUES(?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setInt(1, customerID);
            stmt.setString(2, customerName);
            stmt.setString(3, customerAddress);

            stmt.execute();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }

    /**
     * Deletes a customer from the customer table
     *
     * @param conn       Database Connection
     * @param customerID Customer Identity Number
     */
    public static void deleteCustomer(Connection conn, int customerID) {
        try {

            String query = "delete from Customer where customerID=?";
            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setInt(1, customerID);

            stmt.execute();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }

    /**
     * Display all records of customers from the database.
     * @param connection Database connection
     */
    public static ResultSet viewCustomers(Connection connection) throws SQLException {
        Statement stmt = connection.createStatement();
        return stmt.executeQuery("select * from Customers");
    }

    /**
     * Alter the name of a customer.
     * @param connection Database connection.
     * @param customerID Customer identity number.
     * @param customerName New customer name.
     */
    public static void updateCustomerName(Connection connection,int customerID,String customerName){
        try {
            String query = ""; // TODO Tsenya query
            PreparedStatement stmt = connection.prepareStatement(query);

            stmt.setString(1, customerName);

            stmt.execute();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }

    /**
     * Alter the address of a customer.
     * @param connection Database connection.
     * @param customerID Customer identity number.
     * @param customerAddress New customer address.
     */
    public static void updateCustomerAddress(Connection connection,int customerID,String customerAddress){
        try {
            String query = ""; // TODO Tsenya query
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setInt(1, customerID);
            stmt.setString(2, customerAddress);

            stmt.execute();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }
}
