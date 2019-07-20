package com.tw.apistackbase.controller;

import com.tw.apistackbase.entity.ParkOrder;
import com.tw.apistackbase.entity.Parkinglot;
import com.tw.apistackbase.respository.ParkOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ParkOrderController {
    @Autowired
    private ParkOrderRepository parkOrderRepository;
    @PostMapping("/parkOrders")
    public ResponseEntity<ParkOrder> createParkOrder(@RequestBody ParkOrder parkOrder) {
        ParkOrder newparkOrder=parkOrderRepository.save(parkOrder);
        return ResponseEntity.ok(newparkOrder);
    }

}
