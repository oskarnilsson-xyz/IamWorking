package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SurveilSettings extends JFrame implements ActionListener {

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
    SurveilWindow surveilensWindow;

    public SurveilSettings(SurveilWindow surveilWindow){
        setContentPane(mainPanel);
        setTitle("Settings");
        setSize(400,200);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setIconImage(foxImage.getImage());

        surveilensWindow = surveilWindow;

        chooseColorButton.addActionListener(this);
        goBack3.addActionListener(this);
        confirmButton3.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(goBack3)){
            Splashpage backToSplash = new Splashpage(); // öppnar splachpage
            surveilensWindow.dispose();
            dispose();//stänger ner Settingsfönstret
        }
        if(e.getSource().equals(confirmButton3)) {
            setVisible(false);
        }
    }
}
