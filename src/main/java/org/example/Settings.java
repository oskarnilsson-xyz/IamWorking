package org.example;

import javax.swing.*;

public class Settings extends JFrame {
    private JPanel mainPanel;
    private JPanel center;
    private JPanel bottom;
    private JPanel topp;
    private JCheckBox checkBox1;
    private JCheckBox checkBox2;
    private JCheckBox checkBox3;
    private JCheckBox checkBox4;
    private JCheckBox checkBox5;
    private JCheckBox checkBox6;
    private JButton goBack;
    private JLabel label1;

    ImageIcon foxImage = new ImageIcon("fox.png"); // lade till en icon till vårt fönster

    public Settings(){
        setContentPane(mainPanel);
        setIconImage(foxImage.getImage()); // lägger till iconen till fönstret
        setTitle("I am working");
        setSize(300,300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }


}
