package com.tw.apistackbase.respository;

import com.tw.apistackbase.entity.Parkinglot;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ParkinglotRepository  extends JpaRepository<Parkinglot,Integer> {
    List<Parkinglot> findAllByPageAndPageSize(int page,int pagesize);

}
