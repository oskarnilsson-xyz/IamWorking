package org.example;

import javax.swing.*;

public class GraphicSettings extends JFrame {

    private JPanel mainPanel;
    private JComboBox graphicFile;
    private JLabel chooseFile;
    private JButton goBack;
    private JButton confirmButton;

    ImageIcon foximage = new ImageIcon("src/main/resources/fox.png");

    public GraphicSettings(){
        setContentPane(mainPanel);
        setIconImage(foximage.getImage());
        setTitle("I am working");
        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        setVisible(true);

    }


}
