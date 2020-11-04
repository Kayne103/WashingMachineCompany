import javax.swing.*;
import java.sql.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Company.*;
import Customer.*;
import net.proteanit.sql.DbUtils;

public class appGui extends JFrame{

    private JPanel mainPanel;
    private JTabbedPane maintabbedPane;
    private JPanel CompanyManagement;
    private JPanel customerManagement;
    private JTabbedPane tabbedPane1;
    private JPanel EmployeePanel;
    private JPanel productsPanel;
    private JPanel partsPanel;
    private JPanel machinePanel;
    private JTable employeeTable;
    private JButton addEmployeeButton;
    private JButton deleteEmployeeButton;
    private JTable productTable;
    private JButton addProductButton;
    private JButton deleteProductButton;
    private JButton alterProductsButton;
    private JButton alterEmployeeButton;
    private JButton addPartButton;
    private JTable partsTable;
    private JButton deletePartButton;
    private JButton alterPartButton;
    private JTable machinesTable;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JLabel employeesLabel;
    private JLabel productsLabel;
    private JLabel partsLabel;
    private JLabel machinesLabel;
    private JTabbedPane tabbedPane2;
    private JPanel customerPanel;
    private JPanel ordersPanel;
    private JPanel reportsPanel;
    private JButton registerNewCustomerButton;
    private JButton deleteCustomerButton;
    private JButton changeDetailsOfCustomerButton;
    private JTable ordersTable;
    private JLabel welcomeLabel;
    private JLabel makeAnOrderLabel;
    private JButton orderButton;
    private JTextField productNumberTextField;
    private JTextField customerIdTextField;
    private JTextField quantityTextField;
    private JLabel availableProductsLabel;
    private JLabel productNumberLabel;
    private JLabel customerIdLabel;
    private JLabel quantityLabel;

    public appGui(Connection connection) throws ClassNotFoundException, InstantiationException, IllegalAccessException,
            UnsupportedLookAndFeelException, SQLException {

        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        add(mainPanel);
        setTitle("Washing Machine Company");
        setSize(800,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        addProductButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                    Company.addProduct addProduct = new addProduct(connection);
                    addProduct.setVisible(true);
                try {
                    productTable.setModel(DbUtils.resultSetToTableModel(Product.viewProducts((Connection) connection)));
                } catch (SQLException throwable) {
                    throwable.printStackTrace();
                }
            }
        });

        productTable.setModel(DbUtils.resultSetToTableModel(Company.Product.viewProducts((java.sql.Connection) connection)));
        employeeTable.setModel(DbUtils.resultSetToTableModel(Company.Employee.viewEmployees((java.sql.Connection) connection)));
        machinesTable.setModel(DbUtils.resultSetToTableModel(Company.Machine.viewMachines((java.sql.Connection) connection)));
        partsTable.setModel(DbUtils.resultSetToTableModel(Company.Part.viewParts((java.sql.Connection) connection)));
        orderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Customer.orders.addOrder(connection,productNumberTextField.getText(),customerIdTextField.getText(),Integer.parseInt(quantityTextField.getText()));
            }
        });

        ordersTable.setModel(DbUtils.resultSetToTableModel(Company.Product.viewProducts((java.sql.Connection) connection)));
    }
}
