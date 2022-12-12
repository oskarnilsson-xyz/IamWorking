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
            settings.ConfigRead(null, "fox");

        });

    } @RepeatedTest(5)
    void readConfigSettingTypeIsNull() {
        TextSettings settings = new TextSettings();
        Assertions.assertThrows(RuntimeException.class, () -> {
            settings.ConfigRead("src/main/resources/Config", null);

        });

    }

    @RepeatedTest(5)
    void readConfigReturnsString() {
        TextSettings settings = new TextSettings();
        assertEquals("1", settings.ConfigRead("src/main/resources/Config", "speed1"));


    }

    @RepeatedTest(5)
    void readConfigFailsReturnString() {
        TextSettings settings = new TextSettings();
        assertNull(settings.ConfigRead("src/main/resources/Config", "speed25"));


    }

    @RepeatedTest(5)
    void writeConfig() {
        TextSettings settings = new TextSettings();
        Assertions.assertThrows(RuntimeException.class, () -> {
            settings.ConfigWrite(null, "fox", "fox");
        });
    }
    @RepeatedTest(5)
    void writeConfigSettingTypeIsNull() {
        TextSettings settings = new TextSettings();
        Assertions.assertThrows(RuntimeException.class, () -> {
            settings.ConfigWrite("src/main/resources/Config", null, "fox");
        });

    }
    @RepeatedTest(5)
    void writeConfigWriteValueIsNull() {
        TextSettings settings = new TextSettings();
        Assertions.assertThrows(RuntimeException.class, () -> {
            settings.ConfigWrite("src/main/resources/Config", "currentTextColor", null);
        });
    }

    @RepeatedTest(5)
    void writeConfigWritesString() {
        TextSettings settings = new TextSettings();
        if (!settings.ConfigRead("src/main/resources/Config", "currentTextColor").equals("Green")) {
            settings.ConfigWrite("src/main/resources/Config", "currentTextColor", "Green");
            assertEquals("Green", settings.ConfigRead("src/main/resources/Config", "currentTextColor"));
        } else {
            settings.ConfigWrite("src/main/resources/Config", "currentTextColor", "Black");
            assertEquals("Black", settings.ConfigRead("src/main/resources/Config", "currentTextColor"));
        }
    }


    @RepeatedTest(5)
    void thisShouldChangeTheColorOfTextBasedWindow() {
        JButton button = new JButton("Pink");
        TextBasedWindow textWindow = new TextBasedWindow();
        var textSettings = new TextSettings(textWindow, button);
        ActionEvent mockEvent = mock(ActionEvent.class);
        when(mockEvent.getSource()).thenReturn(button);
        textSettings.setColor(mockEvent);
        assertEquals(Color.pink, textWindow.getPanel1().getBackground());
        assertEquals(Color.pink, textWindow.getMainTextArea().getBackground());

    }
}
