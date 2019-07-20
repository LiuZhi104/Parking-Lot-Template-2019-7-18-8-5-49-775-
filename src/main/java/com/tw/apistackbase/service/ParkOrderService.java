package com.tw.apistackbase.service;

import com.tw.apistackbase.entity.ParkOrder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

public interface ParkOrderService {
    public ResponseEntity getParkOrderResponseEntity( long orderNumber, boolean staus);
    public ResponseEntity<ParkOrder> getOrderResponseEntity(ParkOrder parkOrder,  int id);
}
