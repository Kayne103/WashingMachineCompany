package Company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

public class AssemleProduct extends JFrame{
    private JPanel assembleProductRootPanel;
    private JTextField textFieldproductNum;
    private JTextField textFieldpartID;
    private JButton assembleButton;
    private JLabel productNumberLabel;
    private JLabel partIDLabel;

    public AssemleProduct(Connection connection) {
        add(assembleProductRootPanel);
        setTitle("Assemble Product");
        setSize(315,330);
        assembleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                    Assembles.addAssembles(connection,textFieldpartID.getText(),textFieldproductNum.getText());
                    dispose();
            }
        });
    }
}
