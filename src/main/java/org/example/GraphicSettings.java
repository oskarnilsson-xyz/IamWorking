package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GraphicSettings extends JFrame implements ActionListener {

    private JPanel mainPanel;
    private JComboBox graphicFile;
    private JLabel chooseFile;
    private JButton goBack;
    private JButton confirmButton;

    GraphicInterface graphics;

    ImageIcon foximage = new ImageIcon("src/main/resources/fox.png");

    public GraphicSettings(){
        setContentPane(mainPanel);
        setIconImage(foximage.getImage());
        setTitle("I am working");
        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        setSize(400,200);
        setVisible(true);
        goBack.addActionListener(this);
        confirmButton.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(goBack)){
            Splashpage backToSplash = new Splashpage(); // öppnar splachpage
            graphics.dispose();
            dispose();//stänger ner Settingsfönstret
        }
        if(e.getSource().equals(confirmButton)){
            setVisible(false);
        }
    }
}
