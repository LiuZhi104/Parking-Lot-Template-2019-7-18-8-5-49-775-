package com.tw.apistackbase.controller;

import com.tw.apistackbase.entity.Parkinglot;
import com.tw.apistackbase.respository.ParkinglotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ParkinglotController {
    @Autowired
    private ParkinglotRepository parkinglotRepository;
    @PostMapping("/parkinglots")
    public ResponseEntity<Parkinglot> createParkinglot(@RequestBody Parkinglot parkinglot) {
      Parkinglot newparkinglot=parkinglotRepository.save(parkinglot);
        return ResponseEntity.ok(newparkinglot);
    }

}

