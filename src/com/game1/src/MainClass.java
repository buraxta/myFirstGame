package com.game1.src;

import javax.swing.*;

public class MainClass {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.pack();
        frame.setSize(640,480);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new Game());
        frame.setVisible(true);
    }
}
