package com.tw.apistackbase.service;

import com.tw.apistackbase.entity.Parkinglot;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ParkinglotService {
    public ResponseEntity getResponseEntity(int id,Parkinglot parkinglot);
    public ResponseEntity<List<Parkinglot>> getListResponseEntity(int page,int pageSize);
    public ResponseEntity getResponseEntityById( int id);
    public ResponseEntity<Parkinglot> loadSpecialParkinglot( int id);
}
