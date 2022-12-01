package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class SettingsTest {

    @Test
    void readConfig() {
        Settings settings = new Settings();
        Assertions.assertThrows(RuntimeException.class,() -> {settings.ReadConfig(null, "fox");
        });

    }
    @Test
    void readConfigReturnsString() {
        Settings settings = new Settings();
        assertEquals("1", settings.ReadConfig("src/main/resources/Config", "speed1"));


    }@Test
    void readConfigFailsReturnString() {
        Settings settings = new Settings();
        assertNull(settings.ReadConfig("src/main/resources/Config", "speed25"));


    }

    @Test
    void writeConfig() {
        Settings settings = new Settings();
        Assertions.assertThrows(RuntimeException.class,() -> {settings.WriteConfig(null, "fox", "fox");
        });
    }
    @Test
    void writeConfigWritesString() {
        Settings settings = new Settings();
        if (!settings.ReadConfig("src/main/resources/Config", "currentTextColor").equals("Green")){
            settings.WriteConfig("src/main/resources/Config", "currentTextColor", "Green");
            assertEquals("Green", settings.ReadConfig("src/main/resources/Config", "currentTextColor"));
        }
        else{
            settings.WriteConfig("src/main/resources/Config", "currentTextColor", "Black");
            assertEquals("Black", settings.ReadConfig("src/main/resources/Config", "currentTextColor"));
        }

    }
}