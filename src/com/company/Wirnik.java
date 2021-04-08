package com.company;

public abstract class Wirnik {
    int state;
    boolean flag;
    abstract int getState();
    abstract void setState(int t_state);
    abstract int segregate(int t_char);

}
