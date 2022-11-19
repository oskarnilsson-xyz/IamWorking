package org.example;

import javax.swing.*;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.awt.event.*;
import java.awt.*;


public class Settings extends JFrame {
    private JPanel mainPanel;
    private JPanel center;
    private JPanel bottom;
    private JPanel topp;
    private JCheckBox checkBox1;
    private JCheckBox checkBox2;
    private JCheckBox checkBox3;
    private JCheckBox checkBox4;
    private JCheckBox checkBox5;
    private JCheckBox checkBox6;
    public JButton goBack;
    private JLabel label1;

    ImageIcon foxImage = new ImageIcon("fox.png"); // lade till en icon till våra fönster

    public Settings(){// konstruktor
        initializer();// method som innehåller saker vi vill ha till våra fönster
        setSize(300,300); // specifikt för detta fönster


        goBack.addActionListener(new ActionListener() { // gör så att tillbaka knappen tar en tillbaka till start sida
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource().equals(goBack)){
                    Splashpage backToSplash = new Splashpage(); // öppnar splachpage
                    dispose();//stänger ner Settingsfönstret
                };
            }
        });
    }
    public void setColor(JButton colorSelect){// tänkte testa ändra bagrundsfärg med knaptryck, något jag kanske utvecklar senare

        mainPanel.setBackground(Color.pink);
        topp.setBackground(Color.pink);
        center.setBackground(Color.pink);
        bottom.setBackground(Color.pink);
    }

    private void initializer() {// basic fakta för fönster
        setContentPane(mainPanel);
        setIconImage(foxImage.getImage()); // lägger till iconen till fönstret
        setTitle("I am working");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

}
