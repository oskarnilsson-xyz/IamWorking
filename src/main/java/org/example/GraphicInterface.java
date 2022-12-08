package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GraphicInterface extends JFrame {
    ImageIcon i = new ImageIcon("src/main/resources/img4.gif");
    ImageIcon j = new ImageIcon("src/main/resources/dynamic.gif");

    private JPanel panel1;
    public JPanel getPanel1() {
        return panel1;
    }
    private JButton doStuffButton1;
    private JLabel ilabel;
    private JButton doStuffButton2;
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
        pack();
        doStuffButton1.addActionListener(new ActionListener() {
            /**
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                ilabel.setIcon(i);
            }
        });
        doStuffButton2.addActionListener(new ActionListener() {
            /**
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                ilabel.setIcon(j);
            }
        });
        settingButton.addActionListener(e -> {
            Manager.GraphicSettingsWindow();
        });
    }
}
