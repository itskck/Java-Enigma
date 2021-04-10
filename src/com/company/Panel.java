package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class Panel extends JPanel {
    Szyfrator sz1 = new Szyfrator();
    int stanP=1,stanL=1,stanS=1,znaleziona_szukajka;
    private String szukajka;
    char[] qwerty = {'Q','W','E','R','T','Y','U','I','O','P','A','S','D','F','G','H','J','K','L','Z','X','C','V','B','N','M'};
    private JPanel panel=new JPanel();
    private JLabel[] labelArray = new JLabel[26];
    private JButton[] buttonArray = new JButton[26];
    private ImageIcon icon = new ImageIcon("Java-Enigma/Bez nazwy.png");
    private JLabel lewy;
    private JLabel srodkowy;
    private JLabel prawy;
    private  JButton Leftup;
    private  JButton Leftdown;
    private  JButton middleup;
    private  JButton middledown;
    private  JButton rightup;
    private  JButton rightdown;
    Panel(){
        panel.setBackground(new Color(56,56,56));
        panel.setLayout(null);
        panel.setPreferredSize(new Dimension(800,600));
        int wiersz=0;
        int kolumna=0;
        int adj=0;
        ////////////////////GORNY PANEL
        Leftup=new JButton("↑");
        Leftup.setBounds(150,0,50, 30);
        panel.add(Leftup);
        lewy= new JLabel(String.valueOf(stanL));
        lewy.setFont(new Font("Serif", Font.PLAIN, 14));
        lewy.setForeground(Color.WHITE);
        lewy.setBounds(170,35,50, 30);
        panel.add(lewy);
        panel.repaint();
        Leftdown=new JButton("↑");
        Leftdown.setBounds(150,70,50, 30);
        panel.add(Leftdown);

        middleup=new JButton("↑");
        middleup.setBounds(365,0,50, 30);
        panel.add(middleup);
        srodkowy= new JLabel(String.valueOf(stanS));
        srodkowy.setFont(new Font("Serif", Font.PLAIN, 14));
        srodkowy.setForeground(Color.WHITE);
        srodkowy.setBounds(385,35,50, 30);
        panel.add(srodkowy);
        panel.repaint();
        middledown=new JButton("↑");
        middledown.setBounds(365,70,50, 30);
        panel.add(middledown);

        rightup=new JButton("↑");
        rightup.setBounds(600,0,50, 30);
        panel.add(rightup);
        prawy= new JLabel(String.valueOf(stanP));
        prawy.setFont(new Font("Serif", Font.PLAIN, 14));
        prawy.setForeground(Color.WHITE);
        prawy.setBounds(620,35,50, 30);
        panel.add(prawy);
        panel.repaint();
        rightdown=new JButton("↑");
        rightdown.setBounds(600,70,50, 30);
        panel.add(rightdown);
        ////////////////////KONIEC GORNY PANEL

        ////////////FUNKCJE GORNEGO PANELU(EVENTY)
        Leftup.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (stanL < 26)
                    stanL++;
                else
                    stanL = 1;
                lewy.setText(String.valueOf(stanL));
            }
        });
        Leftdown.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(stanL>1)
                    stanL--;
                else
                    stanL=26;
                lewy.setText(String.valueOf(stanL));
            }
        });


        middleup.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (stanS < 26)
                    stanS++;
                else
                    stanS = 1;
                srodkowy.setText(String.valueOf(stanS));
            }
        });
        middledown.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(stanS>1)
                    stanS--;
                else
                    stanS=26;
                srodkowy.setText(String.valueOf(stanS));
            }
        });


        rightup.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (stanP < 26)
                    stanP++;
                else
                    stanP = 1;
                prawy.setText(String.valueOf(stanP));
            }
        });
        rightdown.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(stanP>1)
                    stanP--;
                else
                    stanP=26;
                prawy.setText(String.valueOf(stanP));
            }
        });
        ////////////////////KONIEC FUNKCJI

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
            labelArray[i] = labelArray[i] = new JLabel(icon);
            labelArray[i].setText(String.valueOf(qwerty[i]));
            labelArray[i].setHorizontalTextPosition(JButton.CENTER);
            labelArray[i].setVerticalAlignment(JButton.CENTER);
            labelArray[i].setForeground(Color.WHITE);
            labelArray[i].setBounds(100+kolumna+adj,300+ wiersz,50,50);
            labelArray[i].setOpaque(false);
            panel.add( labelArray[i]);
            kolumna+=60;
            panel.repaint();
        }
        wiersz=0;
        kolumna=0;
        adj=0;







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
            buttonArray[i] = buttonArray[i] = new JButton(icon);
            buttonArray[i].setText(String.valueOf(qwerty[i]));
            buttonArray[i].setHorizontalTextPosition(JButton.CENTER);
            buttonArray[i].setVerticalAlignment(JButton.CENTER);
            buttonArray[i].setForeground(Color.WHITE);
            buttonArray[i].setBounds(100+kolumna+adj,550+ wiersz,50,50);
            buttonArray[i].setOpaque(false);
            buttonArray[i].setContentAreaFilled(false);
            buttonArray[i].setBorderPainted(false);
            buttonArray[i].setFocusPainted(false);
            panel.add( buttonArray[i]);
            int finalI = i;
            buttonArray[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    szukajka=sz1.szyfruj(buttonArray[finalI].getText().toString(),stanP,stanS,stanL);
                    System.out.println(sz1.szyfruj(buttonArray[finalI].getText().toString(),stanP,stanS,stanL));
                    for(int pom=0; pom<26; pom++){
                        if(szukajka.charAt(0)==qwerty[pom]){
                            znaleziona_szukajka=pom;
                            break;
                        }
                    }
                    labelArray[znaleziona_szukajka].setIcon(new ImageIcon("Java-Enigma/pog.png"));
                    if(stanP>25){
                        stanP=0;
                        stanS++;
                        srodkowy.setText(String.valueOf(stanS));
                    }
                    if(stanS>26){
                        stanS=1;
                        stanL++;
                        srodkowy.setText(String.valueOf(stanS));
                        lewy.setText(String.valueOf(stanL));
                    }
                    if(stanL>26) {
                        stanL = 1;
                        lewy.setText(String.valueOf(stanL));
                    }
                    stanP++;
                    prawy.setText(String.valueOf(stanP));
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

