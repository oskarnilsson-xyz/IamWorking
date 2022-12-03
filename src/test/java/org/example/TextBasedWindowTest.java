package org.example;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class TextBasedWindowTest {
    String filePath = "src/main/resources/files/";
    String programmingText = "programmingText.txt";
    String hackerText = "hackerText";
    /*
    String filePath;
    @BeforeAll
    static void init() {
        this.filePath = "src/main/resources/files/programmingText.txt";
    }
    */

    @Test
    void readprogrammingTextAsStringSuccess() throws IOException {
        String pathToFile = new String(Files.readAllBytes(Paths.get(this.filePath + programmingText)));
    }

    @Test
    public void normalTest() {
        File file = new File("nonExistingFile");
        assertFalse(file.exists());
    }

    @Test
    public void checkIfHackerTextExist() {
        File file = new File(this.filePath + hackerText);
        assertTrue(file.exists());
    }
    @Test
    public void checkIfProgrammingTextExist() {
        File file = new File(this.filePath + programmingText);
        assertTrue(file.exists());
    }

    @Test
    public void checkIfProgrammingTextEndsWithTxtExtension() {
        File file = new File(this.filePath + programmingText);
        int fileLength = file.toString().length();
        int indexOfDot = file.toString().indexOf('.');
        String fileExtension = file.toString().substring(indexOfDot, fileLength);
        assertEquals(".txt", fileExtension);
    }

    @Test
    public void shouldThrowFileNotFoundException() {
        File nonExistingFile = new File("file.does.not.exist");
        //String textFromFile = new String(Files.readAllBytes(Paths.get(this.filePath)));


        /*
        String path = Paths.get("123");
        String file = new String(Files.readAllBytes(Paths.get("123")));
        String pathToFile = new String(Files.readAllBytes(Paths.get("made up path")));
        */
    }
}