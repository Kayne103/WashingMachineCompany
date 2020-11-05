package Company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

public class AddMadeBy extends JFrame{
    private JPanel addMadeByRootPanel;
    private JTextField textField1PartID;
    private JTextField textField2EmployeeNum;
    private JButton addMadeByButton;
    private JLabel partIDLabel;
    private JLabel employeeNumberLabel;

    public AddMadeBy(Connection connection) {
        add(addMadeByRootPanel);
        setTitle("Add Made By");
        setSize(315,330);
        addMadeByButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                MadeBy.addMadeBy(connection,textField1PartID.getText(),textField2EmployeeNum.getText());
                dispose();
            }
        });
    }
}
