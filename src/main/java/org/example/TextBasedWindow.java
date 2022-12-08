package org.example;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.*;
import java.util.ArrayList;

public class TextBasedWindow extends JFrame implements ConfigReadWrite {

    ImageIcon foxImage = new ImageIcon("src/main/resources/fox.png"); // lade till en icon till vårt fönster
    String textToLoad;
    // Text generation variables
    char[] keyInputs = "abcdefghijklmnopqrstuvwxyzåäö".toCharArray(); // List över de tangenter vi vill ska generera kod/text i vårat programm
    int generationSpeed = Integer.parseInt(ConfigRead(Main.configPath, "currentSpeed")); // Antalet tecken som ska generaras vid varje knapptryckning
    int charactersWritten = 0; // Vi behöver något som räknar hur mycket text vi redan skrivit ut så vi kan fortsätta att generera text där vi slutade

    public JPanel getPanel1() {
        return panel1;
    }

    public JTextArea getMainTextArea() {//detta är för testet thisShouldChangeTheColorOfTextBasedWindow()
        return mainTextArea;
    }

    private JPanel panel1;
    private JTextArea mainTextArea;
    private JButton goToSettingsButton;
    private JButton uploadFileButton;

    private JButton enterTextButton;
    public TextBasedWindow() {
        setContentPane(panel1);
        setTitle("Code typer");
        setSize(500, 500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
        setIconImage(foxImage.getImage());
        SetTextWindowFromConfig();


        goToSettingsButton.addActionListener(e -> {
            Manager.TextSettingsWindow(); // :)
        });
        uploadFileButton.addActionListener(e -> { // On button click, import a text file to generate text from
            JFileChooser fileChooser = new JFileChooser();
            FileNameExtensionFilter textFilter = new FileNameExtensionFilter("TEXT FILES", "txt", "text"); // Skapar ett filter som gör att vi bara kan läsa in textfiler
            fileChooser.setFileFilter(textFilter); // Använd filtret på våran fileChooser
            int uploadedFile = fileChooser.showOpenDialog(null); // Opens a window where the user can select a file
            if (uploadedFile == JFileChooser.APPROVE_OPTION) { // If user selected a file
                File filePath = new File(fileChooser.getSelectedFile().getAbsolutePath());
                textToLoad = readFileAsString(String.valueOf(filePath)); // Select the new file as the textToLoad
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
                    if (charactersWritten >= textToLoad.length()) { // If the number of characters that should be written is greater than our total text length, restart from 0
                        charactersWritten = 0;
                    }
                    mainTextArea.setText(textToLoad.substring(0, charactersWritten));
                }
            }
        });
    }

    // Read text from file
    public String readFileAsString(String fileName) {
        try {
            String data;
            data = new String(Files.readAllBytes(Paths.get(fileName)));
            return data;
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void SetTextWindowFromConfig() { //Uppdaterar alla inställningar från current i config
        panel1.setBackground(ConfigColorFinder("currentBackgroundcolor"));
        mainTextArea.setBackground(ConfigColorFinder("currentBackgroundcolor"));
        mainTextArea.setForeground(ConfigColorFinder("currentTextColor"));
        generationSpeed = Integer.parseInt(ConfigRead(Main.configPath, "currentSpeed"));
        textToLoad = readFileAsString(ConfigRead(Main.configPath, (ConfigRead(Main.configPath, "currentFileText"))));
        mainTextArea.setFont(new Font(ConfigRead(Main.configPath, "currentFont"), Font.PLAIN, Integer.parseInt(ConfigRead(Main.configPath, "currentTextSize"))));

    }
}
