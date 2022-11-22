package org.example;
import javax.swing.*;
public class Main {
    public static void main(String[] args) {
        //var TextBasedWindow = new TextBasedWindow();
        //var splashPage = new Splashpage();
        Settings settings = new Settings();

        System.out.println(settings.ReadConfig("src/main/resources/Config", "BackgroundcolorOptions"));
    }
}