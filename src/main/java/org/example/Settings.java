package org.example;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;


public class Settings extends JFrame implements ActionListener{
    private JPanel mainPanel;
    private JPanel center;
    private JPanel bottom;
    private JPanel topp;
    private JCheckBox checkBox2;
    private JCheckBox checkBox3;
    private JCheckBox checkBox4;
    private JButton goBack;
    private JLabel label1;
    private JButton pinkButton;
    private JButton blackButton;
    private JButton whiteButton;
    private JComboBox fileSelect;

    //String[] comboOptions = {"file1", "file2", "file3"};

    ImageIcon foxImage = new ImageIcon("fox.png"); // lade till en icon till våra fönster

    public Settings(){// konstruktor
        initializer();// method som innehåller saker vi vill ha till våra fönster
        setSize(300,300); // specifikt för detta fönster

        goBack.addActionListener(this); //istället för detta går de att använda en lambda expprestion(e -> "de som ska göras")
        pinkButton.addActionListener(this);
        blackButton.addActionListener(this);
        whiteButton.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(goBack)){ // gör så att tillbaka knappen tar en tillbaka till start sida
            Splashpage backToSplash = new Splashpage(); // öppnar splachpage
            dispose();//stänger ner Settingsfönstret
        }
        if(e.getSource().equals(pinkButton)){
            setColor(e);
        } else if (e.getSource().equals(blackButton)) {
            setColor(e);
        } else if (e.getSource().equals(whiteButton)) {
            setColor(e);
        }
    }
    public void setColor(ActionEvent colorSelect){// tänkte testa ändra bagrundsfärg med knaptryck, något jag kanske utvecklar senare

        if(colorSelect.getSource().equals(pinkButton)){
            mainPanel.setBackground(Color.pink);
            topp.setBackground(Color.pink);
            center.setBackground(Color.pink);
            bottom.setBackground(Color.pink);
        }
        if(colorSelect.getSource().equals(blackButton)){
            mainPanel.setBackground(Color.BLACK);
            topp.setBackground(Color.BLACK);
            center.setBackground(Color.BLACK);
            bottom.setBackground(Color.BLACK);
        }
        if(colorSelect.getSource().equals(whiteButton)){
            mainPanel.setBackground(Color.white);
            topp.setBackground(Color.white);
            center.setBackground(Color.white);
            bottom.setBackground(Color.white);
        }

    }

    private void initializer() {// basic fakta för fönster
        setContentPane(mainPanel);
        setIconImage(foxImage.getImage()); // lägger till iconen till fönstret
        setTitle("I am working");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

    }

}
