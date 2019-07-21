package com.tw.apistackbase.service;

import com.tw.apistackbase.entity.Car;
import com.tw.apistackbase.entity.ParkOrder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

public interface ParkOrderService {

    Boolean addNewParkingLotOrder(Car car) throws Exception;

    ParkOrder endParkingLotOrder(Car car);
}
