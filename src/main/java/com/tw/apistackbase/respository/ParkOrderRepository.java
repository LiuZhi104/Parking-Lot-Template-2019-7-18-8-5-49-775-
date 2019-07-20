package com.tw.apistackbase.respository;

import com.tw.apistackbase.entity.ParkOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface ParkOrderRepository extends JpaRepository<ParkOrder,Long> {
    @Modifying
    @Query(value = "update ParkOrder p set p.staus=false where p.orderNumber=?",nativeQuery = true)
    int  updateparkOrder(long orderNumber,boolean status);

}
