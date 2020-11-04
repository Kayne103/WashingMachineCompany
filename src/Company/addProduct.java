package Company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

public class addProduct extends JFrame{
    private JPanel root;
    private JButton addProductButton;
    private JTextField productNumbertextField;
    private JTextField productNametextField;
    private JLabel productNameLabel;
    private JTextField productCosttextField;
    private JLabel productNumberlabel;
    private JLabel productCostLabel;
    private JTextField companyNametextField;
    private JLabel companyNameLabel;

    public addProduct(Connection connection){
        add(root);
        setTitle("Add Products");
        setSize(315,330);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addProductButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Product.addProduct(connection,productNumbertextField.getText(),productNametextField.getText(),Double.parseDouble(productCosttextField.getText()),companyNametextField.getText());
                dispose();
            }
        });
    }
}
