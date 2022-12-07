package org.example;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

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
    void doesTextForTestingFileExist() {
        File file = new File("src/main/resources/textForTesting.txt");
        assertTrue(file.exists());
    }

    //Bestest test
    //BestTestEverForever
    @Test
    void testIfTextForTestingFileIsReadAsString() throws IOException{
        TextBasedWindow textWindow = new TextBasedWindow();
        String våranText = textWindow.readFileAsString("src/main/resources/textForTesting.txt");
        String expectedText = "package org.example;";
        assertEquals(expectedText,våranText);
    }


    @Test
    void readprogrammingTextAsStringSuccess() throws IOException {
        String pathToFile = new String(Files.readAllBytes(Paths.get(this.filePath + programmingText)));
    }


    /* Unused test
    @Test
    void increaseTextInTextWindowOnKeyPress() {
    /*void increaseTextInTextWindowOnKeyPress() throws AWTException{ // For use of robot
        JTextArea testArea = new JTextArea("testTextArea");
        TextBasedWindow textWindow = new TextBasedWindow();
        KeyListener mockListener = mock(KeyListener.class);
        KeyAdapter mockAdapter = mock(KeyAdapter.class);
        KeyEvent mockEvent3 = mock(KeyEvent.class);
        KeyEvent mock4 = mock(KeyEvent.class);
        //when(mockEvent3.getKeyChar(KeyEvent.VK_E));
        when(mockEvent3.getKeyChar());
        //Robot testRobot = new Robot(); // Use robot to stimulate key press

        //when(mockListener.keyTyped(KeyEvent));
        //when(mockListener.keyTyped(KeyEvent);
        //when(mockAdapter.keyTyped((e -> System.out.println("t"))));
        // Stimulate "z" button press
        KeyEvent key = new KeyEvent(textWindow, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0,  KeyEvent.VK_UP,'z');
        textWindow.addKeyListener(mockListener);
        textWindow.getKeyListeners()[0].keyPressed(key);
        when(mockEvent3.(key).thenReturn());
        //var dumTest = textWindow.getKeyListeners();

        //when (mockAdapter.keyPressed(key).thenReturn(testArea));

        //System.out.println(dumTest);
        //.keyPressed(key);

        int writtenCharacters = textWindow.charactersWritten;
        System.out.println(writtenCharacters);

        //when(mockAdapter.key)
        //KeyEvent test = new KeyEvent();
        // when(mockAdapter.keyTyped(())));
    }
    */

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