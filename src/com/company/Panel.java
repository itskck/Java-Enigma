package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class Panel extends JPanel {
    char[] qwerty = {'Q','W','E','R','T','Y','U','I','O','P','A','S','D','F','G','H','J','K','L','Z','X','C','V','B','N','M'};
    private JPanel panel=new JPanel();
    private JButton[] buttonArray = new JButton[26];
    private ImageIcon icon = new ImageIcon("Bez nazwy.png");
    Panel(){
        panel.setBackground(new Color(56,56,56));
        panel.setLayout(null);
        panel.setPreferredSize(new Dimension(800,600));
        int wiersz=0;
        int kolumna=0;
        int adj=0;

        for(int i=0; i<26;i++)
        {

            if(i>=10 && i<=18) {
                wiersz = 60;
                adj=30;
            }
            else{
                adj=0;
            }
            if(i>=19) {
                wiersz= 120;
                adj=90;
            }
            if(i==10 || i==19) kolumna=0;
            ////////////////////////////////////////////////////////////////////////////////////////////
            buttonArray[i] =
            buttonArray[i] = new JButton(icon);
            buttonArray[i].setText(String.valueOf(qwerty[i]));
            buttonArray[i].setHorizontalTextPosition(JButton.CENTER);
            buttonArray[i].setVerticalAlignment(JButton.CENTER);
            buttonArray[i].setForeground(Color.WHITE);
            buttonArray[i].setBounds(100+kolumna+adj,350+ wiersz,50,50);
            buttonArray[i].setOpaque(false);
            buttonArray[i].setContentAreaFilled(false);
            buttonArray[i].setBorderPainted(false);
            buttonArray[i].setFocusPainted(false);
            panel.add( buttonArray[i]);
            int finalI = i;
            buttonArray[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println(buttonArray[finalI].getText());
                }
            });
            kolumna+=60;
            panel.repaint();
        }

    }


    public JPanel getPanel() {
        return panel;
    }
}

