package com.tw.apistackbase.service.iml;

import com.tw.apistackbase.entity.ParkOrder;
import com.tw.apistackbase.entity.Parkinglot;
import com.tw.apistackbase.respository.ParkOrderRepository;
import com.tw.apistackbase.respository.ParkinglotRepository;
import com.tw.apistackbase.service.ParkOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ParkOrderServiceiml implements ParkOrderService {
    @Autowired
    private ParkOrderRepository parkOrderRepository;
    @Autowired
    private ParkinglotRepository parkinglotRepository;
    @Override
    public ResponseEntity getParkOrderResponseEntity(long orderNumber, boolean staus) {
        int value=parkOrderRepository.updateparkOrder(orderNumber,staus);
        ParkOrder parkOrder=parkOrderRepository.findById(orderNumber).get();
        if (value == 1) {
            return ResponseEntity.ok(parkOrder);
        }
        return ResponseEntity.notFound().build();
    }
    @Override
    public ResponseEntity<ParkOrder> getOrderResponseEntity(ParkOrder parkOrder, int id) {
        Parkinglot parkinglot=parkinglotRepository.findById(id).get();
        if(parkinglot.getCapcity()== 0) {
            ParkOrder newparkOrder = parkOrderRepository.save(parkOrder);
            return ResponseEntity.ok(newparkOrder);
        }else{
            return  ResponseEntity.notFound().build();
        }
    }
}
