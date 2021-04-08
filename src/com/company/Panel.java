package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Panel {
    private JPanel panel=new JPanel();
    private JButton[] buttonArray = new JButton[26];

    Panel(){
        panel.setPreferredSize(new Dimension(800,600));
        int wiersz=0;
        int kolumna=0;
        for(int i=0; i<26;i++)
        {

            if(i>9 && i<17) wiersz=30;
            if(i>=17) wiersz= 60;
            buttonArray[i] = new JButton(String.valueOf(i));
            buttonArray[i].setBounds(kolumna,wiersz,200,20);
          // buttonArray[i].setOpaque(false);
          //  buttonArray[i].setContentAreaFilled(false);
          //  buttonArray[i].setBorderPainted(false);
           // buttonArray[i].setFocusPainted(false);
            panel.add( buttonArray[i]);
            kolumna+=30;
            if(kolumna>30*9) kolumna=0;
            panel.repaint();
        }

    }

    public JPanel getPanel() {
        return panel;
    }
}
