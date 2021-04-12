package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Panel extends JPanel {
    Szyfrator sz1 = new Szyfrator();
    int stanP=1,stanL=1,stanS=1,znaleziona_szukajka;
    private String szukajka;
    char[] qwerty = {'Q','W','E','R','T','Y','U','I','O','P','A','S','D','F','G','H','J','K','L','Z','X','C','V','B','N','M'};
    private JPanel panel=new JPanel();
    private ImageIcon backgrnd = new ImageIcon("background.png");
    private JLabel[] labelArray = new JLabel[26];
    private JButton[] buttonArray = new JButton[26];
    private ImageIcon icon = new ImageIcon("button.png");
    private ImageIcon icon2= new ImageIcon("button2.png");
    private JLabel lewy;
    private JLabel srodkowy;
    private JLabel prawy;
    private  JButton Leftup;
    private  JButton Leftdown;
    private  JButton middleup;
    private  JButton middledown;
    private  JButton rightup;
    private  JButton rightdown;
    private JLabel rotorTextureL,rotorTextureR,rotorTextureM,backgroundLabel;
    private boolean rotorLflag=true,rotorRflag=true,rotorMflag=true;
    private ImageIcon iconPrime = new ImageIcon("rotorPrime.png");
    private ImageIcon iconAlt = new ImageIcon("rotorAlt.png");

        Panel(){

        panel.setLayout(null);
        panel.setPreferredSize(new Dimension(800,600));
        panel.setBackground(new Color(58,58,58));
        backgroundLabel = new JLabel();
        backgroundLabel.setIcon(backgrnd);
        backgroundLabel.setBounds(0,0,800,800);
        //backgroundLabel.
       // panel.add(backgroundLabel);

        int wiersz=0;
        int kolumna=0;
        int adj=0;
        ////////////////////GORNY PANEL
        rotorTextureL = new JLabel();
        rotorTextureL.setBounds(150,30,50,190);
        rotorTextureL.setIcon(new ImageIcon("rotorPrime.png"));
        panel.add(rotorTextureL);
        Leftup=new JButton("↑");
        Leftup.setBounds(150,30,50, 70);
        Leftup.setOpaque(false);
        Leftup.setContentAreaFilled(false);
        Leftup.setBorderPainted(false);
        panel.add(Leftup);

        lewy= new JLabel(String.valueOf(stanL));
        lewy.setFont(new Font("Serif", Font.PLAIN, 25));
        lewy.setForeground(Color.WHITE);
        lewy.setBounds(220,110,50, 30);
        panel.add(lewy);
        panel.repaint();
        Leftdown=new JButton("↑");
        Leftdown.setBounds(150,150,50, 70);
        Leftdown.setOpaque(false);
        Leftdown.setContentAreaFilled(false);
        Leftdown.setBorderPainted(false);
        panel.add(Leftdown);

        rotorTextureM = new JLabel();
        rotorTextureM.setBounds(375,30,50,190);
        rotorTextureM.setIcon(new ImageIcon("rotorPrime.png"));
        panel.add(rotorTextureM);
        middleup=new JButton("↑");
        middleup.setBounds(375,30,50, 70);
            middleup.setOpaque(false);
            middleup.setContentAreaFilled(false);
            middleup.setBorderPainted(false);
        panel.add(middleup);
        srodkowy= new JLabel(String.valueOf(stanS));
        srodkowy.setFont(new Font("Serif", Font.PLAIN, 25));
        srodkowy.setForeground(Color.WHITE);
        srodkowy.setBounds(445,110,50, 30);
        panel.add(srodkowy);
        panel.repaint();
        middledown=new JButton("↑");
        middledown.setBounds(375,150,50, 70);
            middledown.setOpaque(false);
            middledown.setContentAreaFilled(false);
            middledown.setBorderPainted(false);
        panel.add(middledown);

        rotorTextureR = new JLabel();
        rotorTextureR.setBounds(600,30,50,190);
        rotorTextureR.setIcon(new ImageIcon("rotorPrime.png"));
        panel.add(rotorTextureR);
        rightup=new JButton("↑");
        rightup.setBounds(600,30,50, 70);
            rightup.setOpaque(false);
            rightup.setContentAreaFilled(false);
            rightup.setBorderPainted(false);
        panel.add(rightup);
        prawy= new JLabel(String.valueOf(stanP));
        prawy.setFont(new Font("Serif", Font.PLAIN, 25));
        prawy.setForeground(Color.WHITE);
        prawy.setBounds(670,110,50, 30);
        panel.add(prawy);
        panel.repaint();
        rightdown=new JButton("↑");
        rightdown.setBounds(600,150,50, 70);
        rightdown.setOpaque(false);
        rightdown.setContentAreaFilled(false);
        rightdown.setBorderPainted(false);
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

                if(rotorLflag) rotorTextureL.setIcon(iconAlt);
                else rotorTextureL.setIcon(iconPrime);
                rotorLflag= !rotorLflag;
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

                if(rotorLflag) rotorTextureL.setIcon(iconAlt);
                else rotorTextureL.setIcon(iconPrime);

                rotorLflag= !rotorLflag;
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

                if(rotorMflag) rotorTextureM.setIcon(iconAlt);
                else rotorTextureM.setIcon(iconPrime);
                rotorMflag= !rotorMflag;
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

                if(rotorMflag) rotorTextureM.setIcon(iconAlt);
                else rotorTextureM.setIcon(iconPrime);
                rotorMflag= !rotorMflag;
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

                if(rotorRflag) rotorTextureR.setIcon(iconAlt);
                else rotorTextureR.setIcon(iconPrime);
                rotorRflag= !rotorRflag;
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

                if(rotorRflag) rotorTextureR.setIcon(iconAlt);
                else rotorTextureR.setIcon(iconPrime);
                rotorRflag= !rotorRflag;
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
            labelArray[i] = labelArray[i] = new JLabel(icon2);
            labelArray[i].setText(String.valueOf(qwerty[i]));
            labelArray[i].setHorizontalTextPosition(JButton.CENTER);
            labelArray[i].setVerticalAlignment(JButton.CENTER);
            labelArray[i].setForeground(Color.WHITE);
            labelArray[i].setBounds(100+kolumna+adj,300+ wiersz,50,50);
            labelArray[i].setOpaque(false);
            labelArray[i].setFont(new Font("Serif", Font.PLAIN, 18));
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
            buttonArray[i].setFont(new Font("Serif", Font.PLAIN, 17));
            panel.add( buttonArray[i]);
            int finalI = i;

            buttonArray[i].addMouseListener(new MouseAdapter() {    //WCISKANIE GUZIKA
                @Override
                public void mousePressed(MouseEvent e) {
                    if (e.getButton() == MouseEvent.BUTTON1) {
                        szukajka = sz1.szyfruj(buttonArray[finalI].getText().toString(), stanP, stanS, stanL);
                        // System.out.println(sz1.szyfruj(buttonArray[finalI].getText().toString(), stanP, stanS, stanL));
                        for (int pom = 0; pom < 26; pom++) {
                            if (szukajka.charAt(0) == qwerty[pom]) {
                                znaleziona_szukajka = pom;
                                break;
                            }
                        }
                        labelArray[znaleziona_szukajka].setIcon(new ImageIcon("buttonLit2.png"));
                        labelArray[znaleziona_szukajka].setForeground(new Color(255,246,220));
                        if (stanP > 25) {
                            stanP = 0;
                            stanS++;
                            srodkowy.setText(String.valueOf(stanS));


                        }
                        if (stanS > 26) {
                            stanS = 1;
                            stanL++;
                            srodkowy.setText(String.valueOf(stanS));
                            lewy.setText(String.valueOf(stanL));
                            if(rotorMflag) rotorTextureM.setIcon(iconAlt);
                            else rotorTextureM.setIcon(iconPrime);
                            rotorMflag= !rotorMflag;
                        }
                        if (stanL > 26) {
                            stanL = 1;
                            lewy.setText(String.valueOf(stanL));
                            if(rotorLflag) rotorTextureL.setIcon(iconAlt);
                            else rotorTextureL.setIcon(iconPrime);

                            rotorLflag= !rotorLflag;
                        }
                        stanP++;
                        prawy.setText(String.valueOf(stanP));
                        if(rotorRflag) rotorTextureR.setIcon(iconAlt);
                        else rotorTextureR.setIcon(iconPrime);
                        rotorRflag= !rotorRflag;
                    }
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    super.mouseReleased(e);
                    labelArray[znaleziona_szukajka].setIcon(new ImageIcon("button2.png"));
                    labelArray[znaleziona_szukajka].setForeground(Color.WHITE);
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

