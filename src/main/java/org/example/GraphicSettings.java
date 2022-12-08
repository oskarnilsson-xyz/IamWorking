package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GraphicSettings extends JFrame implements ActionListener {
    ImageIcon foxImage = new ImageIcon("src/main/resources/fox.png"); // lade till en icon till vårt fönster
    private JPanel mainPanel;
    private JComboBox graphicFile;
    private JLabel chooseFile;
    private JButton goBack2;
    private JButton confirmButton2;
    private JButton chooseColorButton;
    GraphicInterface graphics; //object av fönstret som inställningarna tillhör

    public GraphicSettings() {}
    public GraphicSettings(GraphicInterface graphics){
        this.graphics = graphics;
        setIconImage(foxImage.getImage());
        setContentPane(mainPanel);
        setTitle("Settings");
        setLocationRelativeTo(null);
        setVisible(true);
        setSize(300,260);
        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);



        goBack2.addActionListener(this);
        confirmButton2.addActionListener(this);
        chooseColorButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(chooseColorButton)){
            JColorChooser chooseColor = new JColorChooser();
            Color color = chooseColor.showDialog(null,"Color choice",Color.WHITE);
            graphics.getPanel1().setBackground(color);
            graphics.getPanel2().setBackground(color);
        }
        if (e.getSource().equals(goBack2)){
            Splashpage backToSplash = new Splashpage(); // öppnar splachpage
            graphics.dispose();
            dispose();//stänger ner Settingsfönstret
        }
        if(e.getSource().equals(confirmButton2)){
            setVisible(false);
        }
    }
}
