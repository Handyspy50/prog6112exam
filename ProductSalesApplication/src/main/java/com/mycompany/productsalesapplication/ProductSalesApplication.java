/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.productsalesapplication;

import javax.swing.*;
import java.awt.*;
import java.io.*;

/**
 *
 * @author nkosi
 */
public class ProductSalesApplication extends JFrame {
    JTextField txtCustomer, txtPrice;
    JTextField txtVat, txtCommission, txtTotal;
    JComboBox<String> cmbProduct;

    JButton btnProcess, btnClear, btnExit;

    public ProductSalesApplication(){
        setTitle("Mattress Sales System");
        setSize(450, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(10, 2, 5, 5));

        //Menu bar
        JMenuBar menuBar = new JMenuBar();

        JMenu menu = new JMenu("Menu");

        JMenuItem processItem = new JMenuItem("Process");
        JMenuItem clearItem = new JMenuItem("Clear");
        JMenuItem exitItem = new JMenuItem("Exit");

        menu.add(processItem);
        menu.add(clearItem);
        menu.add(exitItem);

        menuBar.add(menu);
        setJMenuBar(menuBar);

        //Customer name
        add(new JLabel("Customer Name:"));
        txtCustomer = new JTextField();
        add(txtCustomer);

        //Product name
        add(new JLabel("Product Name:"));

        cmbProduct = new JComboBox<>();
        cmbProduct.addItem("COZY NIGHTS MONARCH MATTRESS");
        cmbProduct.addItem("RESTONIC BARDADOS MATTRESS");
        cmbProduct.addItem("SEALY PHUCKET MATTRESS");
        add(cmbProduct);

        //Product price
        add(new JLabel("Product Price:"));
        txtPrice = new JTextField();
        add(txtPrice);

        //VAT
        add(new JLabel("VAT Amount:"));
        txtVat = new JTextField();
        txtVat.setEditable(false);
        add(txtVat);

        //Commission
        add(new JLabel("Commission Amount:"));
        txtCommission = new JTextField();
        txtCommission.setEditable(false);
        add(txtCommission);

        //Total
        add(new JLabel("Total Sales Amount:"));
        txtTotal = new JTextField();
        txtTotal.setEditable(false);
        add(txtTotal);

        //Buttons
        btnProcess = new JButton("Process");
        btnClear = new JButton("Clear");
        btnExit = new JButton("Exit");

        add(btnProcess);
        add(btnClear);

        add(btnExit);
        add(new JLabel(""));

        //Button actions
        btnProcess.addActionListener(e -> process());
        btnClear.addActionListener(e -> clear());
        btnExit.addActionListener(e -> System.exit(0));

        //Menu actions
        processItem.addActionListener(e -> process());
        clearItem.addActionListener(e -> clear());
        exitItem.addActionListener(e -> System.exit(0));

        setLocationRelativeTo(null);
        setVisible(true);
    }

    //Process sales information
    public void process() {
        try {
            String customer = txtCustomer.getText();
            String product = cmbProduct.getSelectedItem().toString();

            double price = Double.parseDouble(txtPrice.getText());

            if (customer.trim().isEmpty() || price <= 0) {
                JOptionPane.showMessageDialog(this,
                        "Please enter a customer name and a valid price.");
                return;
            }

            ProductCalculations calculation = new ProductCalculations(price);

            double vat = calculation.GetVat();
            double commission = calculation.GetCommission();
            double total = calculation.GetTotal();

            //Display results
            txtVat.setText(String.format("%.2f", vat));
            txtCommission.setText(String.format("%.2f", commission));
            txtTotal.setText(String.format("%.2f", total));

            //Save information to file
            BufferedWriter writer = new BufferedWriter(new FileWriter("data.txt", true));

            writer.write("Customer Name: " + customer);
            writer.newLine();

            writer.write("Product Name: " + product);
            writer.newLine();

            writer.write("Product Price: " + price);
            writer.newLine();

            writer.write("VAT Amount: " + vat);
            writer.newLine();

            writer.write("Commission Amount: " + commission);
            writer.newLine();

            writer.write("Total Sales Amount: " + total);
            writer.newLine();

            writer.write("-----------------------------");
            writer.newLine();

            writer.close();

            JOptionPane.showMessageDialog(this, "Sales information processed and saved successfully!");

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid product price.");

        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error saving information to file.");
        }
    }

    //Clear all fields
    public void clear() {
        txtCustomer.setText("");
        txtPrice.setText("");

        txtVat.setText("");
        txtCommission.setText("");
        txtTotal.setText("");

        cmbProduct.setSelectedIndex(0);
    }

    //Main method
    public static void main(String[] args) {

        ProductSalesApplication productSalesApplication = new ProductSalesApplication();
    }
}

