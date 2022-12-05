package org.example;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.*;


public class TextSettings extends JFrame implements ActionListener, ConfigReadWrite {
    TextBasedWindow TBchanges;
    ImageIcon foxImage = new ImageIcon("src/main/resources/fox.png"); // lade till en icon till våra fönster
    private JPanel mainPanel;
    private JPanel topp;
    private JPanel bottom;
    private JPanel center;

    private JLabel fileType;
    private JLabel BKcolor;
    private JLabel Tcolor;
    private JLabel speed;
    private JLabel textSize;

    private JButton goBack;
    private JButton buttonBG1;
    private JButton buttonBG2;
    private JButton buttonBG3;
    private JButton confirmButton;
    public JSlider writingSpeed;
    private JSlider fontsize;
    private JButton buttonTextColor1;
    private JButton buttonTextColor2;
    private JButton buttonTextColor3;
    private JButton buttonTextColor4;
    private JComboBox FontBox;
    private JComboBox fileSelect;

    public TextSettings(TextBasedWindow textBasedWindow, JButton button){
        TBchanges = textBasedWindow;
        buttonBG1 = button;
    }
    public TextSettings(){
    }
    public TextSettings(TextBasedWindow textBasedWindow){// konstruktor
        TBchanges = textBasedWindow;
        initializer();// method som innehåller saker vi vill ha till våra fönster
        setSize(400,460); // specifikt för detta fönster

        ConfigButton();// Detta ger oss möjligheten att ändra på knapparnas utseende och funktionalitet
        writingSpeed.setValue(Integer.parseInt(ConfigRead(Main.configPath,"currentSpeed"))); // gör så att sliders hänger med config-fil
        fontsize.setValue(Integer.parseInt(ConfigRead(Main.configPath,"currentTextSize")));

        goBack.addActionListener(this); //istället för detta går de att använda en lambda expprestion(e -> "de som ska göras")
        confirmButton.addActionListener(this);
        buttonBG1.addActionListener(this);
        buttonBG2.addActionListener(this);
        buttonBG3.addActionListener(this);
        buttonTextColor2.addActionListener(this);
        buttonTextColor3.addActionListener(this);
        buttonTextColor4.addActionListener(this);
        buttonTextColor1.addActionListener(this);

        fontsize.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                String value = Integer.toString(fontsize.getValue());
                ConfigWrite(Main.configPath,"currentSpeed",value);
                TBchanges.setFontSize(ConfigRead(Main.configPath,"currentFont"),fontsize.getValue());

            }
        });
        writingSpeed.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                String value = Integer.toString(writingSpeed.getValue());
                ConfigWrite(Main.configPath,"currentSpeed",value);
                //TBchanges.generationSpeed = writingSpeed.getValue();
                TBchanges.generationSpeed = Integer.parseInt(ConfigRead(Main.configPath,"currentSpeed"));;
            }
        });
        FontBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TBchanges.setFont((String)FontBox.getSelectedItem());
                ConfigWrite(Main.configPath,"currentFont",(String)FontBox.getSelectedItem());
            }
        });
        fileSelect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ConfigWrite(Main.configPath, "currentFileText", (String)fileSelect.getSelectedItem());
                TBchanges.textToLoad = TBchanges.readFileAsString(ConfigRead(Main.configPath, (ConfigRead(Main.configPath, "currentFileText"))));
                TBchanges.count=0;
            }
        });
    }

    @Override //knapparnas funktion
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(goBack)){ // gör så att tillbaka knappen tar en tillbaka till start sida
            Splashpage backToSplash = new Splashpage(); // öppnar splachpage
            TBchanges.dispose();
            dispose();//stänger ner Settingsfönstret
        }
        if(e.getSource().equals(confirmButton)){
            setVisible(false);
            //TBchanges.setVisible(true);
        }
        if(e.getSource().equals(buttonBG1)){
            setColor(e);
        }else if (e.getSource().equals(buttonBG2)) {
            setColor(e);
        }else if (e.getSource().equals(buttonBG3)) {
            setColor(e);
        }else if (e.getSource().equals(buttonTextColor2)) {
            setColor(e);
        }else if (e.getSource().equals(buttonTextColor1)) {
            setColor(e);
        }else if (e.getSource().equals(buttonTextColor4)) {
            setColor(e);
        }else if (e.getSource().equals(buttonTextColor3)) {
            setColor(e);
        }
    }
    public void setColor(ActionEvent colorSelect){//  ändra bakgrundsfärg med knapptryck

        if(colorSelect.getSource().equals(buttonBG1)){
            TBchanges.setPanel1(ConfigColorFinder("backgroundcolor1"));//den går in i config för att läsa parametern
            TBchanges.setBTextArea(ConfigColorFinder("backgroundcolor1"));
            ConfigWrite(Main.configPath,"currentBackgroundcolor",ConfigRead(Main.configPath, "backgroundcolor1"));
        }
        if(colorSelect.getSource().equals(buttonBG2)){
            TBchanges.setPanel1(ConfigColorFinder("backgroundcolor2"));
            TBchanges.setBTextArea(ConfigColorFinder("backgroundcolor2"));
            ConfigWrite(Main.configPath,"currentBackgroundcolor",ConfigRead(Main.configPath, "backgroundcolor2"));
        }
        if(colorSelect.getSource().equals(buttonBG3)){
            TBchanges.setPanel1(ConfigColorFinder("backgroundcolor3"));
            TBchanges.setBTextArea(ConfigColorFinder("backgroundcolor3"));
            ConfigWrite(Main.configPath,"currentBackgroundcolor",ConfigRead(Main.configPath, "backgroundColor3"));
        }
        if(colorSelect.getSource().equals(buttonTextColor4)){
           TBchanges.setFTextArea(ConfigColorFinder("textColor4"));
           ConfigWrite(Main.configPath,"currentTextColor",ConfigRead(Main.configPath, "textColor4"));

        }
        if(colorSelect.getSource().equals(buttonTextColor3)){
            TBchanges.setFTextArea(ConfigColorFinder("textColor3"));
            ConfigWrite(Main.configPath,"currentTextColor",ConfigRead(Main.configPath, "textColor3"));
        }
        if(colorSelect.getSource().equals(buttonTextColor1)){
            TBchanges.setFTextArea(ConfigColorFinder("textColor1"));
            ConfigWrite(Main.configPath,"currentTextColor",ConfigRead(Main.configPath, "textColor1"));
        }
        if(colorSelect.getSource().equals(buttonTextColor2)){
            TBchanges.setFTextArea(ConfigColorFinder("textColor2"));
            ConfigWrite(Main.configPath,"currentTextColor",ConfigRead(Main.configPath, "textColor2"));
        }
    }
    private void initializer() {// basic fakta för fönster
        setContentPane(mainPanel);
        setIconImage(foxImage.getImage()); // lägger till iconen till fönstret
        setTitle("I am working");
        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        setVisible(true);

    }
    public String ReadConfig(String filename, String settingType){
        //ReadConfig("src/main/resources/Config", "BackgroundcolorOptions")//struktur för att kalla informationen
        return ConfigRead(filename, settingType);
    }
    public void WriteConfig(String fileName, String settingType, String writeValue){
        ConfigWrite(fileName, settingType, writeValue);
    }
    void ConfigButton(){

        buttonBG1.setText(ConfigRead(Main.configPath, "backgroundcolor1")); //Ta knappens text från config filen
        buttonBG2.setText(ConfigRead(Main.configPath, "backgroundcolor2")); //Ta knappens text från config filen
        buttonBG3.setText(ConfigRead(Main.configPath, "backgroundcolor3")); //Ta knappens text från config filen
        buttonTextColor2.setText(ConfigRead(Main.configPath, "textColor2")); //Ta knappens text från config filen
        buttonTextColor3.setText(ConfigRead(Main.configPath, "textColor3")); //Ta knappens text från config filen
        buttonTextColor4.setText(ConfigRead(Main.configPath, "textColor4")); //Ta knappens text från config filen
        buttonTextColor1.setText(ConfigRead(Main.configPath, "textColor1")); //Ta knappens text från config filen

        buttonBG1.setBackground(ConfigColorFinder("backgroundcolor1")); //Ta knappens text från config filen
        buttonBG2.setBackground(ConfigColorFinder("backgroundcolor2")); //Ta knappens text från config filen
        buttonBG3.setBackground(ConfigColorFinder( "backgroundcolor3")); //Ta knappens text från config filen
        buttonTextColor2.setBackground(ConfigColorFinder( "textColor2")); //Ta knappens text från config filen
        buttonTextColor3.setBackground(ConfigColorFinder( "textColor3")); //Ta knappens text från config filen
        buttonTextColor4.setBackground(ConfigColorFinder( "textColor4")); //Ta knappens text från config filen
        buttonTextColor1.setBackground(ConfigColorFinder("textColor1")); //Ta knappens text från config filen
    }
}
