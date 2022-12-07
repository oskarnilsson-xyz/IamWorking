package org.example;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Splashpage extends JFrame {

    ImageIcon foxImage = new ImageIcon("src/main/resources/fox.png"); // lade till en icon till vårt fönster
    private JPanel splashpagePanel;
    private JButton textInterfaceButton;
    private JButton graphicInterfaceButton;
    private JButton survielInterfaceButton;

     //TODO lägg till bilder 
    //TODO: Gå igenom public, private osv.
    public Splashpage() {
        setContentPane(splashPagePanel);
        setIconImage(foxImage.getImage()); // lägger till iconen till fönstret

        setTitle("I am working");
        setSize(720, 400);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
        setIconImage(foxImage.getImage());
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        textInterfaceButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent textInterfaceSelected) {
                super.mouseReleased(textInterfaceSelected);
                //Open settings window by creating an object of target frame.
                Manager.TextWindowStart();
                dispose();
            }
        });
        graphicInterfaceButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent graphicInterfaceSelected) {
                super.mouseReleased(graphicInterfaceSelected);
                Manager.GraphicInterfaceWindowStart();
                dispose();
            }
        });
        survielInterfaceButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent survielInterfaceSelected) {
                super.mouseReleased(survielInterfaceSelected);
                Manager.SurvielWindowStart();
                dispose();
            }
        });
    }
}
