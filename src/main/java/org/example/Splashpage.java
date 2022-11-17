package org.example;

import javax.swing.*;

public class Splashpage extends JFrame{

    ImageIcon foxImage = new ImageIcon("fox.png"); // lade till en icon till vårt fönster

    private JPanel splashPagePanel;
    private JButton textInterfaceButton;
    private JButton graphicInterfaceButton;

public Splashpage(){
    setContentPane(splashPagePanel);
    setIconImage(foxImage.getImage()); // lägger till iconen till fönstret
    setTitle("I am working");
    setSize(500,500);
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    setVisible(true);
}
}
