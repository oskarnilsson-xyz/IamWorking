package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class SettingsTest {

    @RepeatedTest(5)
    void readConfig() {
        Settings settings = new Settings();
        Assertions.assertThrows(RuntimeException.class, () -> {
            settings.ReadConfig(null, "fox");
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
    void writeConfigWritesString() {
        Settings settings = new Settings();
        if (!settings.ReadConfig("src/main/resources/Config", "currentTextColor").equals("Green")) {
            settings.WriteConfig("src/main/resources/Config", "currentTextColor", "Green");
            assertEquals("Green", settings.ReadConfig("src/main/resources/Config", "currentTextColor"));
        } else {
            settings.WriteConfig("src/main/resources/Config", "currentTextColor", "Black");
            assertEquals("Black", settings.ReadConfig("src/main/resources/Config", "currentTextColor"));
        }

    }
}