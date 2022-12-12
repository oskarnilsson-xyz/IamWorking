package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;

public class GraphicInterface extends JFrame  {
    public GraphicInterface(boolean testVersion){}
    String input1 ;
    ImageIcon i = new ImageIcon("src/main/resources/img4.gif");
    ImageIcon j = new ImageIcon("src/main/resources/dynamic.gif");
    private JPanel panel1;
    public JPanel getPanel1() {
        return panel1;
    }
    private JButton doStuffButton1;
    public JLabel ilabel;
    private JButton doStuffButton2;
    private JPasswordField passwordField1;

    private JTextField textField1;
    private JButton settingButton;

    public JPanel getPanel2() {
        return panel2;
    }
    private JPanel panel2;

    ImageIcon foxImage = new ImageIcon("src/main/resources/fox.png"); // lade till en icon till våra fönster
    private JButton SettingsButton;
    public GraphicInterface() {
        setContentPane(panel1);
        setIconImage(foxImage.getImage()); // lägger till iconen till fönstret
        setTitle("I am working");
        setSize(400, 600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);
        setIconImage(foxImage.getImage());
        Component doStuff;
        this.add(textField1);
        this.add(passwordField1);
        pack();
        doStuffButton1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                setIcon(i);
            }
        });
        doStuffButton2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                setIcon(j);
            }
        });
        SettingsButton.addActionListener(e -> Manager.GraphicSettingsWindow());

        //public String getText(String input)
    } public void setIcon(ImageIcon imageicon){
        ilabel.setIcon(imageicon);
    }

}