package com.tw.apistackbase.Res;

import com.tw.apistackbase.entity.ParkOrder;
import com.tw.apistackbase.entity.Parkinglot;

import java.util.ArrayList;
import java.util.List;

public class ParkOrderRes {
    private List<ParkOrder> parkOrders=new ArrayList<>();
    public void add(ParkOrder parkOrder){
        this.parkOrders.add(parkOrder);
    }

    public List<ParkOrder> getParkOrders() {
        return parkOrders;
    }
}
