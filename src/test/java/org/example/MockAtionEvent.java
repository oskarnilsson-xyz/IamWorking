package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class MockAtionEvent extends ActionEvent{

    public MockAtionEvent(Object source, int id, String command) {
        super(source, id, command);
    }
    @Override
    public Object getSource(){
        JButton pink = new JButton("Pink");
        return pink;
    }
}
