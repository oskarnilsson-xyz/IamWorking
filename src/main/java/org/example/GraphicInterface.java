package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GraphicInterface extends JFrame {
    private JPanel panel1;
    private JButton doStuffButton;
    //TODO: Gå igenom public, private osv.
    ImageIcon foxImage = new ImageIcon("src/main/resources/e.png"); // lade till en icon till våra fönster
    public GraphicInterface() {
        setContentPane(panel1);
        setIconImage(foxImage.getImage()); // lägger till iconen till fönstret
        setTitle("I am working");
        setSize(600, 600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);
        Component doStuff;
    }
}
