package org.example;



import javax.swing.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import java.io.IOException;

import java.awt.*;
import java.awt.event.ActionEvent;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class SettingsTest {


    @RepeatedTest(5)
    void readConfigFilenameIsNull() {
        Settings settings = new Settings();
        Assertions.assertThrows(RuntimeException.class, () -> {
            settings.ReadConfig(null, "fox");

        });

    } @RepeatedTest(5)
    void readConfigSettingTypeIsNull() {
        Settings settings = new Settings();
        Assertions.assertThrows(RuntimeException.class, () -> {
            settings.ReadConfig("src/main/resources/Config", null);

        });

    }

    @RepeatedTest(5)
    void readConfigReturnsString() {
        Settings settings = new Settings();
        assertEquals("1", settings.ReadConfig("src/main/resources/Config", "speed1"));


    }

    @RepeatedTest(5)
    void readConfigFailsReturnString() {
        Settings settings = new Settings();
        assertNull(settings.ReadConfig("src/main/resources/Config", "speed25"));


    }

    @RepeatedTest(5)
    void writeConfig() {
        Settings settings = new Settings();
        Assertions.assertThrows(RuntimeException.class, () -> {
            settings.WriteConfig(null, "fox", "fox");
        });
    }
    @RepeatedTest(5)
    void writeConfigSettingTypeIsNull() {
        Settings settings = new Settings();
        Assertions.assertThrows(RuntimeException.class, () -> {
            settings.WriteConfig("src/main/resources/Config", null, "fox");
        });

    }
    @RepeatedTest(5)
    void writeConfigWriteValueIsNull() {
        Settings settings = new Settings();
        Assertions.assertThrows(RuntimeException.class, () -> {
            settings.WriteConfig("src/main/resources/Config", "currentTextColor", null);
        });
    }

    @RepeatedTest(5)
    void writeConfigWritesString() {
        Settings settings = new Settings();
        if (!settings.ReadConfig("src/main/resources/Config", "currentTextColor").equals("Green")) {
            settings.WriteConfig("src/main/resources/Config", "currentTextColor", "Green");
            assertEquals("Green", settings.ReadConfig("src/main/resources/Config", "currentTextColor"));
        } else {
            settings.WriteConfig("src/main/resources/Config", "currentTextColor", "Black");
            assertEquals("Black", settings.ReadConfig("src/main/resources/Config", "currentTextColor"));
        }


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