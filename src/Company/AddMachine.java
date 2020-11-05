package Company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

public class AddMachine extends JFrame{
    private JPanel addMachineRootPanel;
    private JTextField machineNOtextField;
    private JTextField machineLocationtextField;
    private JTextField machineNametextField;
    private JButton addMachineButton;

    public AddMachine(Connection connection) {
        add(addMachineRootPanel);
        setTitle("Add Machine");
        setSize(315,330);

        addMachineButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Machine.addMachine(connection,machineNOtextField.getText(),machineNametextField.getText(),machineLocationtextField.getText());
                dispose();
            }
        });
    }
}
