package org.example;

import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;

public class GraphicInterfaceTest { //Yasers test
    @Test
    public void buttonIsWorking() throws NullPointerException{
        GraphicInterface g = new GraphicInterface(true);
        ImageIcon imageicon = new ImageIcon("");
        g.setIcon(imageicon);
        assertEquals(imageicon, g.ilabel.getIcon());
    }
}
