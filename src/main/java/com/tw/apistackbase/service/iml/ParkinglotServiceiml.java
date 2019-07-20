package com.tw.apistackbase.service.iml;

import com.tw.apistackbase.Res.ParkinglotRes;
import com.tw.apistackbase.entity.Parkinglot;
import com.tw.apistackbase.respository.ParkinglotRepository;
import com.tw.apistackbase.service.ParkinglotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class ParkinglotServiceiml implements ParkinglotService {
    @Autowired
    private ParkinglotRes parkinglotRes;
    @Autowired
    private ParkinglotRepository parkinglotRepository;
    @Override
    public ResponseEntity getResponseEntity(int id, Parkinglot parkinglot) {
        ArrayList<Parkinglot> parkinglots= (ArrayList<Parkinglot>) parkinglotRes.getParkinglots().stream().filter(delete->delete.getId()== id).collect(Collectors.toList());
        if(parkinglots.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(parkinglots.remove(parkinglot));
    }

    @Override
    public ResponseEntity<List<Parkinglot>> getListResponseEntity(int page, int pageSize) {
        if (page == 0 || pageSize == 0) {
            return ResponseEntity.notFound().build();
        } else {
            parkinglotRepository.findAll();
            return ResponseEntity.ok(parkinglotRes.getParkinglots().subList(page*(pageSize-1),page*pageSize));
        }
    }

    @Override
    public ResponseEntity getResponseEntityById(int id) {
        int staus = parkinglotRepository.updateParkinglot(id);
        Parkinglot parkinglot=parkinglotRepository.findById(id).get();
        if (staus == 1) {
            return ResponseEntity.ok(parkinglot);
        }
        return ResponseEntity.notFound().build();
    }

    @Override
    public ResponseEntity<Parkinglot> loadSpecialParkinglot(int id) {
        return ResponseEntity.ok(parkinglotRes.getParkinglots().stream().filter(element -> element.getId() == id).findFirst().get());
    }
}
