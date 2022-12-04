package org.example;

import javax.swing.*;


public class FocusWindow extends JFrame {
    private JPanel focusPanel;
    ImageIcon foxImage = new ImageIcon("src/main/resources/fox.png");
    private JButton closeButton;
    private JLabel focusPanelImage;

    public FocusWindow(String image) {
        setContentPane(focusPanel);
        setIconImage(foxImage.getImage()); // lägger till iconen till fönstret
        setTitle("Focus");
        setSize(520, 350);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);
        focusPanelImage.setIcon(new ImageIcon(image));
        closeButton.addActionListener(e -> dispose());
    }
}
