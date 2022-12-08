package org.example;

import java.awt.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;
// Vi förstår att detta inte är en korrekt implementation av interface och att detta egentligen borde ligga i en klass
// En interface ser ut så här: public String ConfigRead(String fileName, String settingType) // och sedan hade varje class gjort en egen implementation.

public interface ConfigReadWrite { //Returnerar en string baserat på en given nyckel(allt till och med = är nyckel.
    default String ConfigRead(String fileName, String settingType){ //Retunerar inställningsvärde från config filen
        Properties prop = new Properties();

        try(FileInputStream fileToRead = new FileInputStream(fileName)) {
            prop.load(fileToRead);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return prop.getProperty(settingType);
    }
    default void ConfigWrite(String fileName, String settingType, String writeValue){ //Skriver över ett värde med nykel 'settingType' med värdet write value.???
        Properties prop = new Properties();
        try(FileInputStream fileToRead = new FileInputStream(fileName)){
            prop.load(fileToRead);
            fileToRead.close();
            prop.setProperty(settingType, writeValue);
            prop.store(new FileOutputStream(fileName), null);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    default Color ConfigColorFinder(String settingType) { //Converts the value in key(settingType) into an object of the Color class.
        Color color;
        try {
            Field field = Color.class.getField(ConfigRead(Main.configPath, settingType).toLowerCase());
            color = (Color) field.get(null);
        } catch (Exception e) {
            color = null; // Not defined
        }
        return color;
    }
    default String ConfigReturnFileName(String settingType){
            Path path = Paths.get(ConfigRead(Main.configPath, settingType));
            Path fileName = path.getFileName();
            return (fileName.toString().replaceFirst("[.][^.]+$", ""));

    }

}
