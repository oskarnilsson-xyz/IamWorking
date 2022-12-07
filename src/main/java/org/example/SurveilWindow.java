package org.example;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Objects;

public class SurveilWindow extends JFrame implements ConfigReadWrite {
    ImageIcon foxImage = new ImageIcon("src/main/resources/fox.png"); // lade till en icon till vårt fönster

    private JButton cam1Button;
    private JPanel surveilWindowPanel;
    private JLabel cam1Feed;
    private JLabel cam1Head;
    private JButton cam2Button;
    private JButton cam3Button;
    private JButton cam4Button;
    private JButton cam12Button;
    private JButton cam8Button;
    private JButton cam7Button;
    private JButton cam6Button;
    private JButton cam5Button;
    private JButton cam11Button;
    private JButton cam10Button;
    private JButton cam9Button;
    private JPanel cam1Panel;
    private JPanel cam6Panel;
    private JPanel cam2Panel;
    private JPanel cam5Panel;
    private JPanel cam9Panel;
    private JPanel cam10Panel;
    private JPanel cam3Panel;
    private JPanel cam7Panel;
    private JPanel cam11Panel;
    private JPanel cam4Panel;
    private JPanel cam8Panel;
    private JPanel cam12Panel;
    private JLabel cam2Head;
    private JLabel cam3Head;
    private JLabel cam4Head;
    private JLabel cam5Head;
    private JLabel cam6Head;
    private JLabel cam7Head;
    private JLabel cam8Head;
    private JLabel cam9Head;
    private JLabel cam10Head;
    private JLabel cam11Head;
    private JLabel cam12Head;
    private JLabel cam2Feed;
    private JLabel cam3Feed;
    private JLabel cam4Feed;
    private JLabel cam5Feed;
    private JLabel cam6Feed;
    private JLabel cam7Feed;
    private JLabel cam8Feed;
    private JLabel cam9Feed;
    private JLabel cam10Feed;
    private JLabel cam11Feed;
    private JLabel cam12Feed;
    private JButton settingButton;
    private JLabel mainHead;
    JLabel[] camFeedArray = {cam1Feed, cam2Feed, cam3Feed, cam4Feed, cam5Feed, cam6Feed, cam7Feed, cam8Feed, cam9Feed, cam10Feed, cam11Feed, cam12Feed};
    JLabel[] headArray = {cam1Head, cam2Head, cam3Head, cam4Head, cam5Head, cam6Head, cam7Head, cam8Head, cam9Head, cam10Head, cam11Head, cam12Head};
    String[] animalCamArray = {"animalCam1", "animalCam2", "animalCam3", "animalCam4", "animalCam5", "animalCam6", "animalCam7", "animalCam8", "animalCam9", "animalCam10", "animalCam11", "animalCam12"};
    String[] nationCamArray = {"nationCam1", "nationCam2", "nationCam3", "nationCam4", "nationCam5", "nationCam6", "nationCam7", "nationCam8", "nationCam9", "nationCam10", "nationCam11", "nationCam12"};
    //TODO: Gå igenom public, private osv.
    //TODO: Waterhole1 filen är felstavad, bråkade när jag försökte ändra den.
    public SurveilWindow() {
        setContentPane(surveilWindowPanel);
        setIconImage(foxImage.getImage()); // lägger till iconen till fönstret
        setTitle("Surveillance");
        setSize(1260, 800);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(true);
        mainHead.setFont(new Font("Serif", Font.PLAIN, 18));
        SetHead();
        try {
            SetFeed();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
//TODO stoppa in if satserna i en metod, för att reducera repetition av kod.
        cam1Button.addActionListener(e -> {
            if (ConfigRead(Main.configPath, "currentCamFeed").equals("Animal")) {
                new FocusWindow(ConfigRead(Main.configPath, "animalCam1"));
            }
            if (ConfigRead(Main.configPath, "currentCamFeed").equals("Nation")) {
                new FocusWindow(ConfigRead(Main.configPath, "nationCam1"));
            }
        });
        cam2Button.addActionListener(e -> {
            if (ConfigRead(Main.configPath, "currentCamFeed").equals("Animal")) {
                new FocusWindow(ConfigRead(Main.configPath, "animalCam2"));
            }
            if (ConfigRead(Main.configPath, "currentCamFeed").equals("Nation")) {
                new FocusWindow(ConfigRead(Main.configPath, "nationCam2"));
            }
        });
        cam3Button.addActionListener(e -> {
            if (ConfigRead(Main.configPath, "currentCamFeed").equals("Animal")) {
                new FocusWindow(ConfigRead(Main.configPath, "animalCam3"));
            }
            if (ConfigRead(Main.configPath, "currentCamFeed").equals("Nation")) {
                new FocusWindow(ConfigRead(Main.configPath, "nationCam3"));
            }
        });
        cam4Button.addActionListener(e -> {
            if (ConfigRead(Main.configPath, "currentCamFeed").equals("Animal")) {
                new FocusWindow(ConfigRead(Main.configPath, "animalCam4"));
            }
            if (ConfigRead(Main.configPath, "currentCamFeed").equals("Nation")) {
                new FocusWindow(ConfigRead(Main.configPath, "nationCam4"));
            }
        });
        cam5Button.addActionListener(e -> {
            if (ConfigRead(Main.configPath, "currentCamFeed").equals("Animal")) {
                new FocusWindow(ConfigRead(Main.configPath, "animalCam5"));
            }
            if (ConfigRead(Main.configPath, "currentCamFeed").equals("Nation")) {
                new FocusWindow(ConfigRead(Main.configPath, "nationCam5"));
            }
        });
        cam6Button.addActionListener(e -> {
            if (ConfigRead(Main.configPath, "currentCamFeed").equals("Animal")) {
                new FocusWindow(ConfigRead(Main.configPath, "animalCam6"));
            }
            if (ConfigRead(Main.configPath, "currentCamFeed").equals("Nation")) {
                new FocusWindow(ConfigRead(Main.configPath, "nationCam6"));
            }
        });
        cam7Button.addActionListener(e -> {
            if (ConfigRead(Main.configPath, "currentCamFeed").equals("Animal")) {
                new FocusWindow(ConfigRead(Main.configPath, "animalCam7"));
            }
            if (ConfigRead(Main.configPath, "currentCamFeed").equals("Nation")) {
                new FocusWindow(ConfigRead(Main.configPath, "nationCam7"));
            }
        });
        cam8Button.addActionListener(e -> {
            if (ConfigRead(Main.configPath, "currentCamFeed").equals("Animal")) {
                new FocusWindow(ConfigRead(Main.configPath, "animalCam8"));
            }
            if (ConfigRead(Main.configPath, "currentCamFeed").equals("Nation")) {
                new FocusWindow(ConfigRead(Main.configPath, "nationCam8"));
            }
        });
        cam9Button.addActionListener(e -> {
            if (ConfigRead(Main.configPath, "currentCamFeed").equals("Animal")) {
                new FocusWindow(ConfigRead(Main.configPath, "animalCam9"));
            }
            if (ConfigRead(Main.configPath, "currentCamFeed").equals("Nation")) {
                new FocusWindow(ConfigRead(Main.configPath, "nationCam9"));
            }
        });
        cam10Button.addActionListener(e -> {
            if (ConfigRead(Main.configPath, "currentCamFeed").equals("Animal")) {
                new FocusWindow(ConfigRead(Main.configPath, "animalCam10"));
            }
            if (ConfigRead(Main.configPath, "currentCamFeed").equals("Nation")) {
                new FocusWindow(ConfigRead(Main.configPath, "nationCam10"));
            }
        });
        cam11Button.addActionListener(e -> {
            if (ConfigRead(Main.configPath, "currentCamFeed").equals("Animal")) {
                new FocusWindow(ConfigRead(Main.configPath, "animalCam11"));
            }
            if (ConfigRead(Main.configPath, "currentCamFeed").equals("Nation")) {
                new FocusWindow(ConfigRead(Main.configPath, "nationCam11"));
            }
        });
        cam12Button.addActionListener(e -> {
            if (ConfigRead(Main.configPath, "currentCamFeed").equals("Animal")) {
                new FocusWindow(ConfigRead(Main.configPath, "animalCam12"));
            }
            if (ConfigRead(Main.configPath, "currentCamFeed").equals("Nation")) {
                new FocusWindow(ConfigRead(Main.configPath, "nationCam12"));
            }
        });
        settingButton.addActionListener(e -> { //TODO: lägg till funktionallitet för ett setting fönster

        });
    }

    //TODO Finns kanske ett bättre sätt?
    public void SetFeed() throws IOException { //Sätter alla bilder till djur temat eller nations temat baserat på config
        String currentFeed = ConfigRead(Main.configPath, "currentCamFeed");
        if (Objects.equals(currentFeed, "Animal")) {
            for (int i = 0; i < 12; i++) {
                camFeedArray[i].setIcon(new ImageIcon(new ImageIcon(ConfigRead(Main.configPath, animalCamArray[i])).getImage().getScaledInstance(camFeedArray[i].getWidth(), camFeedArray[i].getHeight(), Image.SCALE_DEFAULT)));
            }
        }
        if (Objects.equals(currentFeed, "Nation")) {
            for (int i = 0; i < 12; i++) {
                camFeedArray[i].setIcon(new ImageIcon(new ImageIcon(ConfigRead(Main.configPath, nationCamArray[i])).getImage().getScaledInstance(camFeedArray[i].getWidth(), camFeedArray[i].getHeight(), Image.SCALE_DEFAULT)));
            }
        }
    }

    //TODO finns kanske ett bättre sätt?
    public void SetHead() {  //Sätter alla rubriker baserat på currentCamFeed i config
        String currentFeed = ConfigRead(Main.configPath, "currentCamFeed");
        if (Objects.equals(currentFeed, "Animal")) {
            for (int i = 0; i < 12; i++) {
                headArray[i].setText(ConfigReturnFileName(animalCamArray[i]));
            }
        }
        if (Objects.equals(currentFeed, "Nation")) {
            for (int i = 0; i < 12; i++) {
                headArray[i].setText(ConfigReturnFileName(nationCamArray[i]));
            }
        }
    }
}