package Company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

public class AddPart extends JFrame{
    private JPanel addPartRootPanel;
    private JTextField partNametextField;
    private JTextField partIDtextField;
    private JButton addPartButton;
    private JTextField partCosttextField;
    private JLabel partIDLabel;
    private JLabel partNameLabel;
    private JLabel partCostLabel;

    public AddPart(Connection connection) {
        add(addPartRootPanel);
        setTitle("Add Part");
        setSize(315,330);

        addPartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Part.addPart(connection,partIDtextField.getText(),partNametextField.getText(),Double.parseDouble(partCosttextField.getText()));
                dispose();
            }
        });
    }
}
