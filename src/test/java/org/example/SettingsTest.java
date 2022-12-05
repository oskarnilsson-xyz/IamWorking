package org.example;

import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class SettingsTest {
    @Test
    void thisShouldChangeTheColorOfTextBasedWindow(){
        JButton button = new JButton("Pink");
        TextBasedWindow textWindow = new TextBasedWindow();
        var textSettings = new TextSettings(textWindow,button);
        ActionEvent mockEvent = mock(ActionEvent.class);
        when(mockEvent.getSource()).thenReturn(button);
        textSettings.setColor(mockEvent);
        assertEquals(Color.pink,textWindow.getPanel1().getBackground());
        assertEquals(Color.pink,textWindow.getMainTextArea().getBackground());
    }

}