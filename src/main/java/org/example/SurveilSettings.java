package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class SurveilSettings extends JFrame implements ConfigReadWrite{

    ImageIcon foxImage = new ImageIcon("src/main/resources/fox.png"); // lade till en icon till vårt fönster
    private JButton confirmButton3;
    private JButton goBack3;
    private JButton chooseColorButton;
    private JPanel mainPanel;
    private JCheckBox c5;
    private JCheckBox c9;
    private JCheckBox c1;
    private JCheckBox c12;
    private JCheckBox c8;
    private JCheckBox c4;
    private JCheckBox c11;
    private JCheckBox c7;
    private JCheckBox c3;
    private JCheckBox c10;
    private JCheckBox c6;
    private JCheckBox c2;
    private JButton nationsButton;
    private JButton animalsButton;
    private JLabel whatToWatch;

    JCheckBox[] cArray = {c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12};
    SurveilWindow surveilensWindow;
// CamFeed-tema, Bakgrundsfärg, Focusfärg
    public SurveilSettings(SurveilWindow surveilWindow){
        setContentPane(mainPanel);
        setTitle("Settings");
        setSize(450,300);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setIconImage(foxImage.getImage());

        surveilensWindow = surveilWindow;

        animalsButton.addActionListener(e -> ConfigWrite(Main.configPath,"currentCamFeed",ConfigRead(Main.configPath, "CamFeed1")));
        nationsButton.addActionListener(e -> ConfigWrite(Main.configPath,"currentCamFeed",ConfigRead(Main.configPath, "CamFeed2")));

        chooseColorButton.addActionListener(e -> {
            JColorChooser chooseColor = new JColorChooser();
            Color color = chooseColor.showDialog(null,"Color",Color.WHITE);
           for(int i = 0; i < 12; i++){
                if(cArray[i].isSelected()) {
                    surveilensWindow.SetSurvielWindowFocusColor(i, color);
                }
           }
        });
        goBack3.addActionListener(e -> {
            Splashpage backToSplash = new Splashpage(); // öppnar splachpage
            surveilensWindow.dispose();
            dispose();
        });
        confirmButton3.addActionListener(e -> { //
            setVisible(false);
            try {
                surveilensWindow.SetHead();
                surveilensWindow.SetFeed();
                surveilensWindow.repaint();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
    }

}
