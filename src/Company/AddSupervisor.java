package Company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

public class AddSupervisor extends JFrame{
    private JPanel addSupervisor;
    private JTextField textFieldEmployeeNumber;
    private JTextField textFieldMachineNumber;
    private JButton addSupervisorButton;
    private JLabel employeeNumberLabel;
    private JLabel machineNumberLabel;

    public AddSupervisor(Connection connection) {
        add(addSupervisor);
        setTitle("Add Supervisor");
        setSize(315,330);
        addSupervisorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Supervisor.addSupervisor(connection,textFieldEmployeeNumber.getText(),textFieldMachineNumber.getText());
                dispose();
            }
        });
    }
}
