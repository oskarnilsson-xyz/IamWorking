package org.example;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public interface FileReadWrite {
    default String FileRead(String fileName, String settingType){
        Properties prop = new Properties();

        try(FileInputStream read = new FileInputStream(fileName)) {
            prop.load(read);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return prop.getProperty(settingType);
    }
    default void FileWrite(String fileName, String settingType, String writeValue){
        Properties prop = new Properties();
        try(FileInputStream read = new FileInputStream(fileName)){
            prop.load(read);
            read.close();
            prop.setProperty(settingType, writeValue);
            prop.store(new FileOutputStream(fileName), null);

        }catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
