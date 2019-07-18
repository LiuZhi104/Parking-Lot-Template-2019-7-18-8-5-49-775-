package com.tw.apistackbase.entity;

import javax.persistence.*;
import javax.validation.constraints.Min;

@Entity
public class Parkinglot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    @Column(unique = true)
    private String parkingName;
    @Min(value = 0)
    private int capcity;
    private  String position;

    public Parkinglot() {
    }

    public Parkinglot(int id, String parkingName, @Min(value = 0) int capcity, String position) {
        this.id = id;
        this.parkingName = parkingName;
        this.capcity = capcity;
        this.position = position;
    }

    public Parkinglot(String parkingName, @Min(value = 0) int capcity, String position) {
        this.parkingName = parkingName;
        this.capcity = capcity;
        this.position = position;
    }

    public Parkinglot(String parkingName, String position) {
        this.parkingName = parkingName;
        this.position = position;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getParkingName() {
        return parkingName;
    }

    public void setParkingName(String parkingName) {
        this.parkingName = parkingName;
    }

    public int getCapcity() {
        return capcity;
    }

    public void setCapcity(int capcity) {
        this.capcity = capcity;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
