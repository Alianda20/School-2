/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ElectricityManagement;

/**
 *
 * @author HomePC
 */

import java.sql.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Payment extends JFrame implements ActionListener {
    JLabel amountLabel;
    JTextField amountField;
    JButton paymentButton;

    public Payment() {
        super("Pay Bill");

        // create user interface
        setLayout(new FlowLayout());
        setSize(700, 500);
        setLocation(200, 150);

        amountLabel = new JLabel("Enter amount:");
        add(amountLabel);

        amountField = new JTextField(10);
        add(amountField);

        paymentButton = new JButton("Make Payment");
        add(paymentButton);

        // add action listener to payment button
        paymentButton.addActionListener(this);
 // set window properties
        setSize(300, 100);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent event) {
        // get amount from text field
        String amountText = amountField.getText();

        try {
            // parse amount as double
            double amount = Double.parseDouble(amountText);

            // update database to mark payment as paid
            updateDatabase(amount);

            // display success message
            JOptionPane.showMessageDialog(null, "Payment successful");
        } catch (NumberFormatException e) {
            // display error message if amount is not a number
            JOptionPane.showMessageDialog(null, "Invalid amount");
        }
    }
    public void updateDatabase(double amount) {
try{
            // connect to database
            Connection c =  DriverManager.getConnection("jdbc:mysql:///ebs", "root", "");

            // update payment as paid
            String sql = "UPDATE payments SET status='paid' WHERE amount=" + amount;
            Statement stmt = c.createStatement();
            stmt.executeUpdate(sql);

            // close database connection
            c.close();
        } catch (SQLException e) {
            System.out.println("SQL exception occurred: " + e);
        }
    }

    public static void main(String[] args) {
        new Payment();
}
}