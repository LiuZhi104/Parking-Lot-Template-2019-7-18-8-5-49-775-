package com.tw.apistackbase.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class ParkOrder {
    @Id
    @GeneratedValue
    private long oderNumber;
    private String parkinglotName;
    private long carNumber;
    private Date startTime;
    private Date endTime;
    private boolean status;

    public ParkOrder(long oderNumber, String parkinglotName, long carNumber, Date startTime, Date endTime, boolean status) {
        this.oderNumber = oderNumber;
        this.parkinglotName = parkinglotName;
        this.carNumber = carNumber;
        this.startTime = startTime;
        this.endTime = endTime;
        this.status = status;
    }

    public ParkOrder(long oderNumber, String parkinglotName, long carNumber, Date endTime, boolean status) {
        this.oderNumber = oderNumber;
        this.parkinglotName = parkinglotName;
        this.carNumber = carNumber;
        this.endTime = endTime;
        this.status = status;
    }

    public ParkOrder(long oderNumber, long carNumber, Date endTime, boolean status) {
        this.oderNumber = oderNumber;
        this.carNumber = carNumber;
        this.endTime = endTime;
        this.status = status;
    }

    public ParkOrder(long oderNumber, String parkinglotName, long carNumber, boolean status) {
        this.oderNumber = oderNumber;
        this.parkinglotName = parkinglotName;
        this.carNumber = carNumber;
        this.status = status;
    }

    public ParkOrder() {
    }

    public long getOderNumber() {
        return oderNumber;
    }

    public void setOderNumber(long oderNumber) {
        this.oderNumber = oderNumber;
    }

    public String getParkinglotName() {
        return parkinglotName;
    }

    public void setParkinglotName(String parkinglotName) {
        this.parkinglotName = parkinglotName;
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
