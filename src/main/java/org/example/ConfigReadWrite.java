package org.example;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public interface ConfigReadWrite {
    default String ConfigRead(String fileName, String settingType){
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
}
