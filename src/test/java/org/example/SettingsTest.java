package org.example;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.*;
import java.awt.event.ActionEvent;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class SettingsTest {

    @RepeatedTest(5)
    void readConfigFilenameIsNull() {
        TextSettings settings = new TextSettings();
        Assertions.assertThrows(RuntimeException.class, () -> {
            settings.ReadConfig(null, "fox");

        });

    } @RepeatedTest(5)
    void readConfigSettingTypeIsNull() {
        TextSettings settings = new TextSettings();
        Assertions.assertThrows(RuntimeException.class, () -> {
            settings.ReadConfig("src/main/resources/Config", null);

        });

    }

    @RepeatedTest(5)
    void readConfigReturnsString() {
        TextSettings settings = new TextSettings();
        assertEquals("1", settings.ReadConfig("src/main/resources/Config", "speed1"));


    }

    @RepeatedTest(5)
    void readConfigFailsReturnString() {
        TextSettings settings = new TextSettings();
        assertNull(settings.ReadConfig("src/main/resources/Config", "speed25"));


    }

    @RepeatedTest(5)
    void writeConfig() {
        TextSettings settings = new TextSettings();
        Assertions.assertThrows(RuntimeException.class, () -> {
            settings.WriteConfig(null, "fox", "fox");
        });
    }
    @RepeatedTest(5)
    void writeConfigSettingTypeIsNull() {
        TextSettings settings = new TextSettings();
        Assertions.assertThrows(RuntimeException.class, () -> {
            settings.WriteConfig("src/main/resources/Config", null, "fox");
        });

    }
    @RepeatedTest(5)
    void writeConfigWriteValueIsNull() {
        TextSettings settings = new TextSettings();
        Assertions.assertThrows(RuntimeException.class, () -> {
            settings.WriteConfig("src/main/resources/Config", "currentTextColor", null);
        });
    }
    @RepeatedTest(5)
    void writeConfigWritesString() {
        TextSettings settings = new TextSettings();
        if (!settings.ReadConfig("src/main/resources/Config", "currentTextColor").equals("Green")) {
            settings.WriteConfig("src/main/resources/Config", "currentTextColor", "Green");
            assertEquals("Green", settings.ReadConfig("src/main/resources/Config", "currentTextColor"));
        } else {
            settings.WriteConfig("src/main/resources/Config", "currentTextColor", "Black");
            assertEquals("Black", settings.ReadConfig("src/main/resources/Config", "currentTextColor"));
        }
    }
    @Test
    void thisShouldChangeTheColorOfTextBasedWindow(){// testar så att metoden läser av ActionEvent och utför rätt kommando utifrån de
        JButton pink = new JButton();
        pink.setText("Pink");
        var textWindow = new TextBasedWindow();
        var subjectUnderTest = new TextSettings(textWindow,pink);
        ActionEvent mockEvent = mock(ActionEvent.class);
        //var mockEvent = new MockAtionEvent(pink,0,"");
        when(mockEvent.getSource()).thenReturn(pink);
        subjectUnderTest.setColor(mockEvent);
        assertEquals(Color.pink,textWindow.getPanel1().getBackground());
        assertEquals(Color.pink,textWindow.getMainTextArea().getBackground());

    }
}


