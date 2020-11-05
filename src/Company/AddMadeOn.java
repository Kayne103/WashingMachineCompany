package Company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

public class AddMadeOn extends JFrame{
    private JPanel addMadeOnRootPanel;
    private JTextField textField1MachineNumber;
    private JTextField textField2PartID;
    private JButton submitButton;

    public AddMadeOn(Connection connection) {
        add(addMadeOnRootPanel);
        setTitle("Made On");
        setSize(315,330);
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                MadeON.addMadeON(connection,textField2PartID.getText(),textField1MachineNumber.getText());
                dispose();
            }
        });
    }
}
