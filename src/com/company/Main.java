package com.company;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Enigma");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new Panel().getPanel());
        frame.setResizable(false);
        frame.setPreferredSize(new Dimension(800,600));
        frame.pack();
        frame.setVisible(true);

    }
}
//487