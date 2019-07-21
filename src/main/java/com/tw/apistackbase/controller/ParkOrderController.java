package com.tw.apistackbase.controller;

import com.tw.apistackbase.entity.Car;
import com.tw.apistackbase.entity.ParkOrder;
import com.tw.apistackbase.entity.Parkinglot;
import com.tw.apistackbase.respository.ParkOrderRepository;
import com.tw.apistackbase.respository.ParkinglotRepository;
import com.tw.apistackbase.service.ParkOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ParkOrderController {
    @Autowired
    private ParkOrderRepository parkOrderRepository;
    @Autowired
    private ParkOrderService parkOrderService;
    @PostMapping("/parkOrders")
    public ResponseEntity addNewParkingLotOrder(@RequestBody Car car) throws Exception {
        Boolean pakringResult = parkOrderService.addNewParkingLotOrder(car);
        if(pakringResult){
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }
        return  ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @PutMapping("/parkOrders")
    public ResponseEntity<Object> endParkingLotOrder(@RequestBody Car car){
        ParkOrder newParkOrder = parkOrderService.endParkingLotOrder(car);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(newParkOrder);
    }


}
