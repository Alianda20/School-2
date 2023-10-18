package ElectricityManagement;


import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author HomePC
 */
import javax.swing.*;
public class Billcalculation {

    public Billcalculation()  {
        double Bill = Double.parseDouble(JOptionPane.showInputDialog(null,"Enter the units consumed"));
        double totalBill = Bill * 7.5;
        JOptionPane.showMessageDialog(null,"Total bill: KES" + totalBill);
}
}

