package org.example;

import javax.swing.*;

public class Manager implements ConfigReadWrite {

    public static TextBasedWindow textBasedWindow;
    public static GraphicInterface graphicInterfaceWindow;
    public static SurveilWindow survielWindow;
    public static Splashpage splashPageWindow;

    public Manager() {

        var splashPageWindow = new Splashpage();
    }
    public static void TextSettingsWindow() {
        var text = new TextSettings(textBasedWindow);
    } public static void SurveilSettingsWindow() {
        var surveil = new SurveilSettings(survielWindow);
    } public static void GraphicSettingsWindow() {
        var text = new GraphicSettings(graphicInterfaceWindow);  //Implementera när graphic interface
    }

    public static void TextWindowStart() {
        textBasedWindow = new TextBasedWindow();
    }
    public static void SurvielWindowStart() {
        survielWindow = new SurveilWindow();
    }
    public static void GraphicInterfaceWindowStart() {
        graphicInterfaceWindow = new GraphicInterface();
    }

//TODO: Refreshing loop of interface windows to fetch latest settings?
//TODO: Trådar?
    //TODO 3rd window
//TODO 3rd Window settingWindow

}
