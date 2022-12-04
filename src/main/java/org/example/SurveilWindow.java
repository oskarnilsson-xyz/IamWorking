package org.example;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class SurveilWindow extends JFrame implements ConfigReadWrite {
    ImageIcon foxImage = new ImageIcon("src/main/resources/fox.png"); // lade till en icon till vårt fönster

    private JButton cam1Button;
    private JPanel survielWindowPanel;
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

    public SurveilWindow() {
        setContentPane(survielWindowPanel);
        setIconImage(foxImage.getImage()); // lägger till iconen till fönstret
        setTitle("Surviel");
        setSize(1260, 800);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(true);
        mainHead.setFont(new Font("Serif", Font.PLAIN, 18));


        try {
            SetAnimalFeed();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        SetHead(ConfigRead(Main.configPath, "currentCamFeed"));
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
        settingButton.addActionListener(e -> {

        });
    }

    public void SetAnimalFeed() throws IOException {//TODO Flytta till en metod som tar emot parametrar istället ocheller måste finnas ett bättre sätt
        cam1Feed.setIcon(new ImageIcon(new ImageIcon(ConfigRead(Main.configPath, "animalCam1")).getImage().getScaledInstance(cam1Feed.getWidth(), cam1Feed.getHeight(), Image.SCALE_DEFAULT)));
        cam2Feed.setIcon(new ImageIcon(new ImageIcon(ConfigRead(Main.configPath, "animalCam2")).getImage().getScaledInstance(cam2Feed.getWidth(), cam2Feed.getHeight(), Image.SCALE_DEFAULT)));
        cam3Feed.setIcon(new ImageIcon(new ImageIcon(ConfigRead(Main.configPath, "animalCam3")).getImage().getScaledInstance(cam3Feed.getWidth(), cam3Feed.getHeight(), Image.SCALE_DEFAULT)));
        cam4Feed.setIcon(new ImageIcon(new ImageIcon(ConfigRead(Main.configPath, "animalCam4")).getImage().getScaledInstance(cam4Feed.getWidth(), cam4Feed.getHeight(), Image.SCALE_DEFAULT)));
        cam5Feed.setIcon(new ImageIcon(new ImageIcon(ConfigRead(Main.configPath, "animalCam5")).getImage().getScaledInstance(cam5Feed.getWidth(), cam5Feed.getHeight(), Image.SCALE_DEFAULT)));
        cam6Feed.setIcon(new ImageIcon(new ImageIcon(ConfigRead(Main.configPath, "animalCam6")).getImage().getScaledInstance(cam6Feed.getWidth(), cam6Feed.getHeight(), Image.SCALE_DEFAULT)));
        cam7Feed.setIcon(new ImageIcon(new ImageIcon(ConfigRead(Main.configPath, "animalCam7")).getImage().getScaledInstance(cam7Feed.getWidth(), cam7Feed.getHeight(), Image.SCALE_DEFAULT)));
        cam8Feed.setIcon(new ImageIcon(new ImageIcon(ConfigRead(Main.configPath, "animalCam8")).getImage().getScaledInstance(cam8Feed.getWidth(), cam8Feed.getHeight(), Image.SCALE_DEFAULT)));
        cam9Feed.setIcon(new ImageIcon(new ImageIcon(ConfigRead(Main.configPath, "animalCam9")).getImage().getScaledInstance(cam9Feed.getWidth(), cam9Feed.getHeight(), Image.SCALE_DEFAULT)));
        cam10Feed.setIcon(new ImageIcon(new ImageIcon(ConfigRead(Main.configPath, "animalCam10")).getImage().getScaledInstance(cam10Feed.getWidth(), cam10Feed.getHeight(), Image.SCALE_DEFAULT)));
        cam11Feed.setIcon(new ImageIcon(new ImageIcon(ConfigRead(Main.configPath, "animalCam11")).getImage().getScaledInstance(cam11Feed.getWidth(), cam11Feed.getHeight(), Image.SCALE_DEFAULT)));
        cam12Feed.setIcon(new ImageIcon(new ImageIcon(ConfigRead(Main.configPath, "animalCam12")).getImage().getScaledInstance(cam12Feed.getWidth(), cam12Feed.getHeight(), Image.SCALE_DEFAULT)));


    }

    public void SetNationFeed() throws IOException { //TODO Flytta till en metod som tar emot parametrar istället ocheller måste finnas ett bättre sätt
        cam1Feed.setIcon(new ImageIcon(new ImageIcon(ConfigRead(Main.configPath, "nationCam1")).getImage().getScaledInstance(cam1Feed.getWidth(), cam1Feed.getHeight(), Image.SCALE_DEFAULT)));
        cam2Feed.setIcon(new ImageIcon(new ImageIcon(ConfigRead(Main.configPath, "nationCam2")).getImage().getScaledInstance(cam2Feed.getWidth(), cam2Feed.getHeight(), Image.SCALE_DEFAULT)));
        cam3Feed.setIcon(new ImageIcon(new ImageIcon(ConfigRead(Main.configPath, "nationCam3")).getImage().getScaledInstance(cam3Feed.getWidth(), cam3Feed.getHeight(), Image.SCALE_DEFAULT)));
        cam4Feed.setIcon(new ImageIcon(new ImageIcon(ConfigRead(Main.configPath, "nationCam4")).getImage().getScaledInstance(cam4Feed.getWidth(), cam4Feed.getHeight(), Image.SCALE_DEFAULT)));
        cam5Feed.setIcon(new ImageIcon(new ImageIcon(ConfigRead(Main.configPath, "nationCam5")).getImage().getScaledInstance(cam5Feed.getWidth(), cam5Feed.getHeight(), Image.SCALE_DEFAULT)));
        cam6Feed.setIcon(new ImageIcon(new ImageIcon(ConfigRead(Main.configPath, "nationCam6")).getImage().getScaledInstance(cam6Feed.getWidth(), cam6Feed.getHeight(), Image.SCALE_DEFAULT)));
        cam7Feed.setIcon(new ImageIcon(new ImageIcon(ConfigRead(Main.configPath, "nationCam7")).getImage().getScaledInstance(cam7Feed.getWidth(), cam7Feed.getHeight(), Image.SCALE_DEFAULT)));
        cam8Feed.setIcon(new ImageIcon(new ImageIcon(ConfigRead(Main.configPath, "nationCam8")).getImage().getScaledInstance(cam8Feed.getWidth(), cam8Feed.getHeight(), Image.SCALE_DEFAULT)));
        cam9Feed.setIcon(new ImageIcon(new ImageIcon(ConfigRead(Main.configPath, "nationCam9")).getImage().getScaledInstance(cam9Feed.getWidth(), cam9Feed.getHeight(), Image.SCALE_DEFAULT)));
        cam10Feed.setIcon(new ImageIcon(new ImageIcon(ConfigRead(Main.configPath, "nationCam10")).getImage().getScaledInstance(cam10Feed.getWidth(), cam10Feed.getHeight(), Image.SCALE_DEFAULT)));
        cam11Feed.setIcon(new ImageIcon(new ImageIcon(ConfigRead(Main.configPath, "nationCam11")).getImage().getScaledInstance(cam11Feed.getWidth(), cam11Feed.getHeight(), Image.SCALE_DEFAULT)));
        cam12Feed.setIcon(new ImageIcon(new ImageIcon(ConfigRead(Main.configPath, "nationCam12")).getImage().getScaledInstance(cam12Feed.getWidth(), cam12Feed.getHeight(), Image.SCALE_DEFAULT)));


    }

    public void SetHead(String camType) { //TODO clean up måste finnas ett bättre sätt

        if (camType.equals("Nation")) {
            cam1Head.setText(ConfigReturnFileName("nationCam1"));
            cam2Head.setText(ConfigReturnFileName("nationCam2"));
            cam3Head.setText(ConfigReturnFileName("nationCam3"));
            cam4Head.setText(ConfigReturnFileName("nationCam4"));
            cam5Head.setText(ConfigReturnFileName("nationCam5"));
            cam6Head.setText(ConfigReturnFileName("nationCam6"));
            cam7Head.setText(ConfigReturnFileName("nationCam7"));
            cam8Head.setText(ConfigReturnFileName("nationCam8"));
            cam9Head.setText(ConfigReturnFileName("nationCam9"));
            cam10Head.setText(ConfigReturnFileName("nationCam10"));
            cam11Head.setText(ConfigReturnFileName("nationCam11"));
            cam12Head.setText(ConfigReturnFileName("nationCam12"));
        }
        if (camType.equals("Animal")) {
            cam1Head.setText(ConfigReturnFileName("animalCam1"));
            cam2Head.setText(ConfigReturnFileName("animalCam2"));
            cam3Head.setText(ConfigReturnFileName("animalCam3"));
            cam4Head.setText(ConfigReturnFileName("animalCam4"));
            cam5Head.setText(ConfigReturnFileName("animalCam5"));
            cam6Head.setText(ConfigReturnFileName("animalCam6"));
            cam7Head.setText(ConfigReturnFileName("animalCam7"));
            cam8Head.setText(ConfigReturnFileName("animalCam8"));
            cam9Head.setText(ConfigReturnFileName("animalCam9"));
            cam10Head.setText(ConfigReturnFileName("animalCam10"));
            cam11Head.setText(ConfigReturnFileName("animalCam11"));
            cam12Head.setText(ConfigReturnFileName("animalCam12"));
        }
    }
}