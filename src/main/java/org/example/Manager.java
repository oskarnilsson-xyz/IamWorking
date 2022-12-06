package org.example;

public class Manager implements ConfigReadWrite {

    public static TextBasedWindow textBasedWindow;
    public static GraphicInterface graphicInterfaceWindow;

    public static SurveilWindow survielWindow;

    public Manager() {

        var splashPageWindow = new Splashpage();
    }

    public static void TextSettingsWindow() {
        var text = new TextSettings(textBasedWindow);
    }

    public static void TextWindowStart() {
        textBasedWindow = new TextBasedWindow();
    }

    public static void SurvielWindowStart() {
        survielWindow = new SurveilWindow();
    }


    public static void GraphicSettingsWindow() {
        //var text = new GraphicSettings(graphicInterfaceWindow);  //Implementera när graphic interface
    }

    public static void GraphicInterfaceWindowStart() {
        // Hohoho, merry christmas!

        graphicInterfaceWindow = new GraphicInterface();

    }

//TODO: Refreshing loop of interface windows to fetch latest settings?
//TODO: Trådar?
    //TODO 3rd window
//TODO 3rd Window settingWindow

}
