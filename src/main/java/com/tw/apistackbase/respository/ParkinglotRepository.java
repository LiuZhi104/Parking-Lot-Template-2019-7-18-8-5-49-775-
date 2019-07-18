package com.tw.apistackbase.respository;

import com.tw.apistackbase.entity.Parkinglot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface ParkinglotRepository  extends JpaRepository<Parkinglot,Integer> {
    List<Parkinglot> findAllByPageAndPageSize(int page,int pagesize);
    @Modifying
    @Query(value = "update parkinglot p set p.capcity=p.capcity+200 where p.id=?",nativeQuery = true)
   int  updateParkinglot(int id);
}
