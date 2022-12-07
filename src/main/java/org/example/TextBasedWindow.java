package org.example;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.*;

public class TextBasedWindow extends JFrame implements ConfigReadWrite{

    public void setPanel1(Color color) {
        panel1.setBackground(color);
    }

    public JPanel getPanel1() {
        return panel1;
    }
    private JPanel panel1;

    public JTextArea getMainTextArea() {
        return mainTextArea;
    }

    private JTextArea mainTextArea;
    public void setFont(String f){
        mainTextArea.setFont(new Font(f,Font.PLAIN,mainTextArea.getFont().getSize()));
    }
    public void setFontSize(String font, int size){
        mainTextArea.setFont(new Font(font,Font.PLAIN, size));
    }
    public void setBTextArea(Color color){
        mainTextArea.setBackground(color);
    }public void setFTextArea(Color color){
        mainTextArea.setForeground(color);
    }
    private JButton goToSettingsButton;
    private JButton uploadFileButton;
    private JButton enterTextButton;

//TODO: Gå igenom public, private osv.
//TODO: Klassen kommer behövas städas upp efter vi har fått in att allt uppdateras från config,
    // Read text from file
    public static String readFileAsString(String fileName){
        try {
            String data = "";
            data = new String(Files.readAllBytes(Paths.get(fileName)));
            return data;
        } catch (FileNotFoundException e) {
            System.out.println(e);
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    String textToLoad;

    // Text generation variables
    char[] keyInputs = "abcdefghijklmnopqrstuvwxyzåäö".toCharArray(); // List över de tangenter vi vill ska generera kod/text i vårat programm
    int generationSpeed = Integer.parseInt(ConfigRead(Main.configPath,"currentSpeed")); // Antalet tecken som ska generaras vid varje knapptryckning
    int charactersWritten = 0; // Vi behöver något som räknar hur mycket text vi redan skrivit ut så vi kan fortsätta att generera text där vi slutade


    public TextBasedWindow() {     //TODO:TextBasedWindow fetch current settings from config on construction och gör det
        setContentPane(panel1);    //TODO: och gör det i en separat metod så att vi kan kalla på den vid behov.
        setTitle("Code typer");
        setSize(500, 500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        mainTextArea.setBackground(ConfigColorFinder("currentBackgroundcolor"));// sätter färgen via Config filen
        panel1.setBackground(ConfigColorFinder("currentBackgroundcolor"));
        mainTextArea.setForeground(ConfigColorFinder("currentTextcolor"));

        textToLoad = readFileAsString(ConfigRead(Main.configPath, (ConfigRead(Main.configPath, "currentFileText"))));

        goToSettingsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 Manager.TextSettingsWindow(); // :)
            }
        });
        uploadFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { // On button click, import a text file to generate text from
                JFileChooser fileChooser = new JFileChooser();
                FileNameExtensionFilter textFilter = new FileNameExtensionFilter("TEXT FILES", "txt", "text"); // Skapar ett filter som gör att vi bara kan läsa in textfiler
                fileChooser.setFileFilter(textFilter); // Använd filtret på våran fileChooser
                int uploadedFile = fileChooser.showOpenDialog(null); // Opens a window where the user can select a file
                if (uploadedFile == JFileChooser.APPROVE_OPTION) { // If user selected a file
                    File filePath = new File(fileChooser.getSelectedFile().getAbsolutePath());
                    textToLoad = readFileAsString(String.valueOf(filePath)); // Select the new file as the textToLoad
                }
            }
        });
        // Todo - Decide whether to implement this or remove it entirely
        enterTextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Should it be an option to just enter a copied text?");
            }
        });

        // KeyListener, to listen when we press keys on our keyboard
        mainTextArea.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) { // e är våran knapptryckning, e.getKeyChar använder vi för att se tecken det är på tangenten vi tryckte på.
                /* Nedan sker följande:
                   Vi gör om våran array of char(characters) till en sträng.
                   Sedan letar vi efter vilken plats(index) i våran sträng som tecknet för våran knapptryckning har.
                   Om den inte hittar tecknet i våran sträng så returnerar den -1, så vi behöver bara kolla resultat är lika med eller större än index 0.
                   På så sätt kan vi generera text vid knapptryckning endast med de tecken som vi vill ska vara giltiga, vilket vi definerar i keyInputs */
                if (new String(keyInputs).indexOf(e.getKeyChar()) >= 0) {
                    System.out.println(e.getKeyChar());
                    charactersWritten += generationSpeed;
                    if(charactersWritten >= textToLoad.length()) { // If the number of characters that should be written is greater than our total text length, restart from 0
                        charactersWritten = 0;
                    }
                    mainTextArea.setText(textToLoad.substring(0, charactersWritten));
                }
            }
        });
    }
}
