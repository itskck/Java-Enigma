package com.company;

public class Srodkowy extends Wirnik{
    public Srodkowy() {
        flag=false;
    }

    @Override
    int segregate(int t_char) {
        int zmieniony =t_char;
        if(t_char<65){
            int oIle = 65-t_char;
            int mod = oIle / 26;
            zmieniony=t_char+(26*(mod+1));

        }
        if(t_char>90)
        {
            int oIle = t_char-90;
            int mod = oIle / 26;
            zmieniony=t_char-(26*(mod+1));
        }

        return zmieniony;
    }

    @Override
    int getState() {
        return state;
    }

    @Override
    void setState(int t_state) {
        state=t_state;
    }

    int zamien(int wejsciowa){
        int wyjsciowa = 0;

        if(!flag)
            wejsciowa+=state;
        else wejsciowa-=state;

        wyjsciowa=segregate(wejsciowa);
        flag=!flag;
        return wyjsciowa;
    }
}
