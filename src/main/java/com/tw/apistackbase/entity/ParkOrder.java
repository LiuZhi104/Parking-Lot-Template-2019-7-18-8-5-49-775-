package com.tw.apistackbase.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class ParkOrder {
    @Id
    @GeneratedValue
    private long oderNumber;

    @OneToOne
    @JoinColumn(name = "parkinglotName")
    private Parkinglot parkinglot;

    private long carNumber;
    private Date startTime;
    private Date endTime;
    private boolean status;
    public ParkOrder() {
    }

    public Parkinglot getParkinglot() {
        return parkinglot;
    }

    public void setParkinglot(Parkinglot parkinglot) {
        this.parkinglot = parkinglot;
    }

    public long getOderNumber() {
        return oderNumber;
    }

    public void setOderNumber(long oderNumber) {
        this.oderNumber = oderNumber;
    }

    public long getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(long carNumber) {
        this.carNumber = carNumber;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
