package com.tw.apistackbase.service;

import org.springframework.http.ResponseEntity;

public interface ParkOrderService {
    public ResponseEntity getParkOrderResponseEntity( long orderNumber, boolean staus);
}
