package Company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

public class AddEmployee extends JFrame{
    private JPanel employeeRootPanel;
    private JTextField employeeIDtextField;
    private JTextField employeeSalarytextField;
    private JTextField employeeNametextField;
    private JTextField employeePositiontextField;
    private JButton addEmployeeButton;
    private JLabel employeeIDLabel;
    private JLabel employeeNameLabel;
    private JLabel employeePositionSalary;
    private JLabel employeeSalaryLabel;

    public AddEmployee(Connection connection) {
        add(employeeRootPanel);
        setTitle("Add Employee");
        setSize(315,330);

        addEmployeeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Company.Employee.addEmployee(connection,employeeIDtextField.getText(),employeeNametextField.getText(),Double.parseDouble(employeeSalarytextField.getText()),employeePositiontextField.getText());
                dispose();
            }
        });
    }
}
