package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GraphicInterface extends JFrame  {
    ImageIcon i = new ImageIcon("src/main/resources/img4.gif");
    ImageIcon j = new ImageIcon("src/main/resources/dynamic.gif");
    ImageIcon foxImage = new ImageIcon("src/main/resources/fox.png"); // lade till en icon till våra fönster
    private JPanel panel1;
    public JPanel getPanel1() {
        return panel1;
    }
    private JPanel panel2;
    public JPanel getPanel2() {
        return panel2;
    }
    private JButton doStuffButton1;
    private JButton doStuffButton2;
    private JButton settingButton;
    public JLabel ilabel;

    public GraphicInterface(boolean testVersion){}
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
        settingButton.addActionListener(e -> Manager.GraphicSettingsWindow());

        //public String getText(String input)
    }
    public void setIcon(ImageIcon imageicon){
        ilabel.setIcon(imageicon);
    }
}