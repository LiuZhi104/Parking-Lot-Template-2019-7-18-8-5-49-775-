package com.tw.apistackbase;

import com.tw.apistackbase.entity.Parkinglot;

import java.util.ArrayList;
import java.util.List;

public class ParkinglotRes {
    private List<Parkinglot> parkinglots=new ArrayList<>();
    public void add(Parkinglot parkinglot){
        this.parkinglots.add(parkinglot);
    }

    public List<Parkinglot> getParkinglots() {
        return parkinglots;
    }

}
