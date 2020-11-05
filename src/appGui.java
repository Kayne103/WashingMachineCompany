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
    private JTable productTable;
    private JButton addProductButton;
    private JButton addPartButton;
    private JTable partsTable;
    private JTable machinesTable;
    private JButton addMachineButton;
    private JLabel employeesLabel;
    private JLabel productsLabel;
    private JLabel partsLabel;
    private JLabel machinesLabel;
    private JTabbedPane tabbedPane2;
    private JPanel customerPanel;
    private JPanel ordersPanel;
    private JPanel reportsPanel;
    private JButton registerNewCustomerButton;
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
    private JTextField pNumtextField;
    private JButton searchForCustomerButton;
    private JLabel pNumLabel;
    private JButton searchForEmployeeButton;
    private JButton searchForPartsButton;
    private JTextField MachineLocationtextField;
    private JButton searchForMachineButton;
    private JButton assembleProductButton;
    private JButton addSupervisorButton;
    private JButton addOperatorButton;
    private JButton addMadeOnButton;
    private JButton addMadeByButton;

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
        searchForCustomerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    Reports.searchForCustomer(connection,pNumtextField.getText());
                } catch (SQLException throwable) {
                    throwable.printStackTrace();
                }
            }
        });
        addEmployeeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new AddEmployee(connection).setVisible(true);
            }
        });
        addPartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new AddPart(connection).setVisible(true);
            }
        });
        addMachineButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                    new AddMachine(connection).setVisible(true);
            }
        });

        registerNewCustomerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new Customer.AddCustomer(connection).setVisible(true);
            }
        });
        addSupervisorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new Company.AddSupervisor(connection).setVisible(true);
            }
        });
        addOperatorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new AddOperator(connection).setVisible(true);
            }
        });
        assembleProductButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new AssemleProduct(connection).setVisible(true);
            }
        });
        addMadeOnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new AddMadeOn(connection).setVisible(true);
            }
        });
        addMadeByButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new AddMadeBy(connection).setVisible(true);
            }
        });
    }
}
