package com.company;

public class Szyfrator {
    public Szyfrator() {

    }

    public String szyfruj(String zdanie, int statep, int states, int statel){


        int tmp=0,tmp2;
        String wyjscie="";

        Prawy p1=new Prawy();
        Srodkowy s1 = new Srodkowy();
        Lewy l1 = new Lewy();
        Odwracacz o1 = new Odwracacz();

        p1.setState(statep);
        s1.setState(states);
        l1.setState(statel);

        for(char znak: zdanie.toCharArray()) {
           // System.out.println(znak);
            if(znak==' '){
                wyjscie+=' ';
                continue;
            }
            tmp = p1.zamien(znak);
           // System.out.println(tmp);
            tmp2 = s1.zamien(tmp);
           // System.out.println(tmp2);
            tmp = l1.zamien(tmp2);
           // System.out.println(tmp);
            tmp2 = o1.odwroc(tmp);
           // System.out.println(tmp2);
            tmp = l1.zamien(tmp2);
           // System.out.println(tmp);
            tmp2 = s1.zamien(tmp);
           // System.out.println(tmp2);
            tmp = p1.zamien(tmp2);
           // System.out.println(tmp);
            char charout= (char) tmp;

            p1.setState(p1.getState() + 1);
            if (p1.getState() > 26) {
                p1.setState(1);
                s1.setState(s1.getState() + 1);
                if (s1.getState() > 26) {
                    s1.setState(1);
                    l1.setState(l1.getState() + 1);
                    if (l1.getState() > 26) l1.setState(1);
                }
            }
            wyjscie+=charout;
            //System.out.println(p1.getState());
        }
        return wyjscie;
    }
}
