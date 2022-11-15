package org.example;

import javax.swing.*;

public class Splashpage extends JFrame{


    private JPanel splashPagePanel;
    private JButton textInterfaceButton;
    private JButton graphicInterfaceButton;

public Splashpage(){
    setContentPane(splashPagePanel);
    setTitle("I am working");
    setSize(500,500);
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    setVisible(true);
}
}
