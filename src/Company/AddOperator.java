package Company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

public class AddOperator extends JFrame{
    private JPanel addOperatorPanel;
    private JTextField textFieldEmployeeNumber;
    private JTextField textFieldMachineNumber;
    private JButton addOperatorButton;
    private JLabel machineNumberLabel;
    private JLabel employeeNumberLabel;

    public AddOperator(Connection connection) {
        add(addOperatorPanel);
        setTitle("Add Operator");
        setSize(315,330);

        addOperatorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Operator.addOperator(connection,textFieldEmployeeNumber.getText(),textFieldMachineNumber.getText());
            }
        });
    }
}
