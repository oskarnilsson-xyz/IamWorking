package org.example;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.*;
import java.awt.*;


public class Settings extends JFrame implements ActionListener,FileReadWrite{
    private JPanel mainPanel;
    private JPanel center;
    private JPanel bottom;
    private JPanel topp;
    private JButton goBack;

    private JLabel label1;
    private JButton pinkButton;
    private JButton blackButton;
    private JButton whiteButton;
    private JComboBox fileSelect;
    private JButton confirmButton;
    private JSlider writingSpeed;
    private JSlider textsize;
    private JLabel speed;
    private JLabel textSize;
    private JLabel BKcolor;
    private JLabel Tcolor;
    private JButton greenButton;
    private JButton redButton;
    private JButton bbText;
    private JButton wbText;
    private JLabel fileType;

    //String[] comboOptions = {"file1", "file2", "file3"};
    TextBasedWindow TBchanges = new TextBasedWindow();
    ImageIcon foxImage = new ImageIcon("src/main/resources/fox.png"); // lade till en icon till våra fönster

    public Settings(){// konstruktor
        initializer();// method som innehåller saker vi vill ha till våra fönster
        setSize(400,460); // specifikt för detta fönster

        goBack.addActionListener(this); //istället för detta går de att använda en lambda expprestion(e -> "de som ska göras")
        confirmButton.addActionListener(this);
        pinkButton.addActionListener(this);
        blackButton.addActionListener(this);
        whiteButton.addActionListener(this);
        redButton.addActionListener(this);
        bbText.addActionListener(this);
        wbText.addActionListener(this);
        greenButton.addActionListener(this);

        textsize.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {

            }
        });
        writingSpeed.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {

            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(goBack)){ // gör så att tillbaka knappen tar en tillbaka till start sida
            Splashpage backToSplash = new Splashpage(); // öppnar splachpage
            dispose();//stänger ner Settingsfönstret
        }
        if(e.getSource().equals(confirmButton)){
            TBchanges = new TextBasedWindow();
        }
        if(e.getSource().equals(pinkButton)){
            setColor(e);
        }else if (e.getSource().equals(blackButton)) {
            setColor(e);
        }else if (e.getSource().equals(whiteButton)) {
            setColor(e);
        }else if (e.getSource().equals(redButton)) {
            setColor(e);
        }else if (e.getSource().equals(greenButton)) {
            setColor(e);
        }else if (e.getSource().equals(wbText)) {
            setColor(e);
        }else if (e.getSource().equals(bbText)) {
            setColor(e);
        }
    }
    public void setColor(ActionEvent colorSelect){// tänkte testa ändra bagrundsfärg med knaptryck, något jag kanske utvecklar senare

        if(colorSelect.getSource().equals(pinkButton)){
            TBchanges.setPanel1(Color.pink);
            TBchanges.setBTextArea(Color.pink);
        }
        if(colorSelect.getSource().equals(blackButton) || colorSelect.getSource().equals(bbText)){
            TBchanges.setPanel1(Color.black);
            TBchanges.setBTextArea(Color.black);
            if(colorSelect.getSource().equals(bbText)){
                TBchanges.setFTextArea(Color.black);
            }
        }
        if(colorSelect.getSource().equals(whiteButton) || colorSelect.getSource().equals(wbText)){
            TBchanges.setPanel1(Color.white);
            TBchanges.setBTextArea(Color.white);
            if(colorSelect.getSource().equals(wbText)){
                TBchanges.setFTextArea(Color.white);
            }
        }
        if(colorSelect.getSource().equals(greenButton)){
            TBchanges.setFTextArea(Color.green);
        }
        if(colorSelect.getSource().equals(redButton)){
            TBchanges.setFTextArea(Color.red);
        }

    }
    private void initializer() {// basic fakta för fönster
        setContentPane(mainPanel);
        setIconImage(foxImage.getImage()); // lägger till iconen till fönstret
        setTitle("I am working");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

    }
    public String ReadConfig(String filename, String value){
        //ReadConfig("src/main/resources/Config", "BackgroundcolorOptions")//struktur för att kalla informationen
        return FileRead(filename, value);
    }
}
