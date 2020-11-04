import javax.swing.*;
import java.sql.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Company.*;
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
    private JTable table1;
    private JButton deletePartButton;
    private JButton alterPartButton;
    private JTable table2;
    private JButton button1;
    private JButton button2;
    private JButton button3;

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
    }
}
