package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class Main {
    private JPanel Root;
    private JRadioButton rbPostcard;
    private JRadioButton rbLetter;
    private JRadioButton rbPackage;
    private JButton btnPrice;
    private JButton btnConfirm;
    private JTextField tfAddress;
    private JTextField tfZipCode;
    private JTextField tfCity;
    private JPanel panRadio;
    private JPanel panForm;
    private JLabel labZipCode;
    private JLabel labCity;
    private JLabel labAddress;
    private JLabel labOptionImage;
    private JLabel labPrice;

    public Main() {
        btnPrice.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String price = "";
                URL img = null;
                if(rbPostcard.isSelected()){
//                    Postcard
                    price = "1";
                    img = getClass().getResource("/pocztowka.png");
                } else if (rbLetter.isSelected()) {
//                    Letter
                    price = "1,5";
                    img = getClass().getResource("/list.png");
                } else if(rbPackage.isSelected()){
//                    Package
                    price = "10";
                    img = getClass().getResource("/paczka.png");
                }
                labPrice.setText("Cena: " + price + " zł");
                if(img != null) labOptionImage.setIcon(new ImageIcon(img));
            }
        });
        btnConfirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = tfZipCode.getText();
//                Is len 5
                if(input.length() != 5) {
                    JOptionPane.showMessageDialog(Root, "Nieprawidłowa liczba cyfr w kodzie pocztowym");
                    return;
                }
//                Is All Numbers
                try {
                    Integer.parseInt(input);
                } catch (Exception exception) {
                    JOptionPane.showMessageDialog(Root, "Kod pocztowy powinien się składać z samych cyfr");
                    return;
                }
//                Valid
                JOptionPane.showMessageDialog(Root, "Dane przesyłki zostały wprowadzone");
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Nadaj Przesyłkę, PESEL: XYZ");
        Main main = new Main();
        frame.setContentPane(main.Root);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}