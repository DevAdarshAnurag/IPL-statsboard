package com.adarsh.ipl.statsboard.Model;

public class Pair<E> {
    private E data1, data2;

    public Pair(E data1, E data2) {
        this.data1 = data1;
        this.data2 = data2;
    }

    public E getData1() {
        return data1;
    }

    public void setData1(E data1) {
        this.data1 = data1;
    }

    public E getData2() {
        return data2;
    }

    public void setData2(E data2) {
        this.data2 = data2;
    }
}
