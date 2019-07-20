package com.tw.apistackbase.controller;

import com.tw.apistackbase.entity.ParkOrder;
import com.tw.apistackbase.entity.Parkinglot;
import com.tw.apistackbase.respository.ParkOrderRepository;
import com.tw.apistackbase.respository.ParkinglotRepository;
import com.tw.apistackbase.service.ParkOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ParkOrderController {
    @Autowired
    private ParkOrderRepository parkOrderRepository;
    @Autowired
    private ParkOrderService parkOrderService;
    @PostMapping("/parkOrders")
    public ResponseEntity<ParkOrder> createParkOrder(@RequestBody ParkOrder parkOrder,@RequestParam int id) {
        return parkOrderService.getOrderResponseEntity(parkOrder,id);
    }

    @PutMapping("/parkOrders/{orderNumber}")
    public ResponseEntity updateParkOrder(@PathVariable long orderNumber,@RequestParam(required = true) boolean staus) {
        return parkOrderService.getParkOrderResponseEntity(orderNumber,staus);
    }



}
