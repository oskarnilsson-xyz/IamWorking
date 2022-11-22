package org.example;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Splashpage extends JFrame{

    ImageIcon foxImage = new ImageIcon("src/main/resources/fox.png"); // lade till en icon till vårt fönster

    private JPanel splashPagePanel;
    private JButton textInterfaceButton;
    private JButton graphicInterfaceButton;

public Splashpage(){
    setContentPane(splashPagePanel);
    setIconImage(foxImage.getImage()); // lägger till iconen till fönstret
    setTitle("I am working");
    setSize(500,400);
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    setVisible(true);
    setLocationRelativeTo(null);
    setResizable(false);

    textInterfaceButton.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseReleased(MouseEvent textInterfaceSelected) {
            super.mouseReleased(textInterfaceSelected);

            //Open settings window by creating an object of target frame.
            TextBasedWindow textBasedWindow = new TextBasedWindow();
            Settings settingsWindow = new Settings();
            dispose();
        }
    });
    graphicInterfaceButton.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseReleased(MouseEvent graphicInterfaceSelected) {
            super.mouseReleased(graphicInterfaceSelected);

            //Open settings window by creating an object of target frame.
            GraphicInterface graphicInterfaceWindow = new GraphicInterface();
            dispose();
        }
    });
}

}
