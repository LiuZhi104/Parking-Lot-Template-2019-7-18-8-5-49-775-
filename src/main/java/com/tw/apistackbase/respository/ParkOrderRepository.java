package com.tw.apistackbase.respository;

import com.tw.apistackbase.entity.ParkOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface ParkOrderRepository extends JpaRepository<ParkOrder,Long> {
    @Query(value = "select * from  PARKORDER where CARID = ?1 and STATUS=true",nativeQuery = true)
    ParkOrder findOpenOrderByCarId(int carId);

}
