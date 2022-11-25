package org.example;

import java.awt.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Properties;

public interface ConfigReadWrite {
    default String ConfigRead(String fileName, String settingType){ //Retunerar inställningsvärde från config filen
        Properties prop = new Properties();

        try(FileInputStream read = new FileInputStream(fileName)) {
            prop.load(read);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return prop.getProperty(settingType);
    }
    default void ConfigWrite(String fileName, String settingType, String writeValue){
        Properties prop = new Properties();
        try(FileInputStream read = new FileInputStream(fileName)){
            prop.load(read);
            read.close();
            prop.setProperty(settingType, writeValue);
            prop.store(new FileOutputStream(fileName), null);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    default Color ConfigColorFinder(String settingType) {

        Color color;
        try {
            Field field = Color.class.getField(ConfigRead(Main.configPath, settingType));
            color = (Color) field.get(null);
        } catch (Exception e) {
            color = null; // Not defined
        }
        return color;
    }

}
