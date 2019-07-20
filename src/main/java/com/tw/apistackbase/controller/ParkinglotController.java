package com.tw.apistackbase.controller;

import com.tw.apistackbase.Res.ParkinglotRes;
import com.tw.apistackbase.entity.Parkinglot;
import com.tw.apistackbase.respository.ParkinglotRepository;
import com.tw.apistackbase.service.ParkinglotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ParkinglotController {
    @Autowired
    private ParkinglotService parkinglotService;
    @Autowired
    private ParkinglotRepository parkinglotRepository;
    @Autowired
    private ParkinglotRes parkinglotRes;
    @PostMapping("/parkinglots")
    public ResponseEntity<Parkinglot> createParkinglot(@RequestBody Parkinglot parkinglot) {
      Parkinglot newparkinglot=parkinglotRepository.save(parkinglot);
        return ResponseEntity.ok(newparkinglot);
    }
    @DeleteMapping("/parkinglots/{id}")
    public ResponseEntity deleteParkinglot(@PathVariable int id, @RequestBody Parkinglot parkinglot) {
        return parkinglotService.getResponseEntity(id,parkinglot);
    }

    @GetMapping("/parkinglots")
    public ResponseEntity<List<Parkinglot>> getHasPageAndPageSize(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue ="0") int pageSize) {
        return parkinglotService.getListResponseEntity(page,pageSize);
    }
    @GetMapping("/parkinglots/{id}")
    public ResponseEntity<Parkinglot> getSpecialParkinglot(@PathVariable int id) {
        return parkinglotService.loadSpecialParkinglot(id);
    }
    @PutMapping("/parkings/{id}")
    public ResponseEntity updateCompany(@PathVariable int id) {
        return parkinglotService.getResponseEntityById(id);
    }

}

