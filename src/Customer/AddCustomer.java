package Customer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

public class AddCustomer extends JFrame{
    private JPanel addCustomerRootPanel;
    private JTextField textFieldCustomerID;
    private JTextField textFieldCustomerAddress;
    private JTextField textFieldCustomerName;
    private JButton addCustomerButton;

    public AddCustomer(Connection connection) {
        add(addCustomerRootPanel);
        setTitle("Add Customer");
        setSize(315,330);

        addCustomerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                customer.addCustomer(connection,Integer.parseInt(textFieldCustomerID.getText()),textFieldCustomerName.getText(),textFieldCustomerAddress.getText());
                dispose();
            }
        });
    }
}
