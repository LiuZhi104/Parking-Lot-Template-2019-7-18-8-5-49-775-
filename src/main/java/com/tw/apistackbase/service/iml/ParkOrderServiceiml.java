package com.tw.apistackbase.service.iml;

import com.tw.apistackbase.entity.Car;
import com.tw.apistackbase.entity.ParkOrder;
import com.tw.apistackbase.entity.Parkinglot;
import com.tw.apistackbase.respository.ParkOrderRepository;
import com.tw.apistackbase.respository.ParkinglotRepository;
import com.tw.apistackbase.service.ParkOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ParkOrderServiceiml implements ParkOrderService {
    @Autowired
    private ParkOrderRepository parkOrderRepository;
    @Autowired
    private ParkinglotRepository parkinglotRepository;

    @Override
    public Boolean addNewParkingLotOrder(Car car) throws Exception {
        Parkinglot parkinglot =parkinglotRepository.findAll().get(0);
        if(parkinglot.parkingCarIntoParkingLot(car)){
            ParkOrder parkOrder = new ParkOrder();
            parkOrder.setParkinglot(parkinglot);
            parkOrder.setCarNumber(car.getCarId());
            parkOrder.setStartTime(new Date());
            parkOrder.setStatus(true);
            ParkOrder po = parkOrderRepository.save(parkOrder);
            return po != null;
        }
        return false;
    }
    @Override
    public ParkOrder endParkingLotOrder(Car car) {
        ParkOrder openOrder =parkOrderRepository.findOpenOrderByCarId(car.getCarId());
        openOrder.setStatus(false);
        openOrder.setEndTime(new Date());
        ParkOrder endOrder = parkOrderRepository.saveAndFlush(openOrder);
        return endOrder;
    }
}
