package org.example;

import javax.swing.*;
import java.awt.*;

public class GraphicInterface extends JFrame {
    ImageIcon foxImage = new ImageIcon("src/main/resources/fox.png"); // lade till en icon till vårt fönster
    private JPanel mainPanel;
    private JButton SettingsButton;
    public GraphicInterface() {
        setContentPane(mainPanel);
        setSize(500, 550);
        setTitle("I am working");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
        setIconImage(foxImage.getImage());
        Component doStuff;
        SettingsButton.addActionListener(e -> Manager.GraphicSettingsWindow());
    }
}
