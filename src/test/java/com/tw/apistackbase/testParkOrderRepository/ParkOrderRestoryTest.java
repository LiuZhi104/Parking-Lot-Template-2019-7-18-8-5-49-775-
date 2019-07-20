package com.tw.apistackbase.testParkOrderRepository;

import com.tw.apistackbase.entity.ParkOrder;
import com.tw.apistackbase.entity.Parkinglot;
import com.tw.apistackbase.respository.ParkOrderRepository;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class ParkOrderRestoryTest {
    @Autowired
    private ParkOrderRepository parkOrderRepository;
    @Test
    public void should_can_add_when_property_null() {
        //given
        ParkOrder parkOrder=new ParkOrder();
        //when// /then
        Assertions.assertThrows(Exception.class,()->{
            parkOrderRepository.saveAndFlush(parkOrder);
        });
    }
    @Test
    public void should_return_size_when_the_add() {
        //given
        ParkOrder parkOrder=new ParkOrder(1001,"AODI",1,true);
        parkOrderRepository.save(parkOrder);
        ParkOrder parkOrder1=new ParkOrder(1002,"FUTE",2,true);
        parkOrderRepository.save(parkOrder1);
        ParkOrder parkOrder2=new ParkOrder(1003,"MEIHE",3,true);
        parkOrderRepository.save(parkOrder2);
        ParkOrder parkOrder3=new ParkOrder(1004,"JIAII",4,true);
        parkOrderRepository.save(parkOrder3);
        //when
       List<ParkOrder> parkOrders=parkOrderRepository.findAll();
        //then
        Assertions.assertEquals(4,parkOrders.size());
    }
    @Test
    public  void should_get_status_is_false_parkorder_information_when_has_parkingorder_by_orderNumber_and_status(){
        //given
        ParkOrder parkOrder=new ParkOrder(1001,"AODI",1,true);
        parkOrderRepository.save(parkOrder);
        ParkOrder parkOrder1=new ParkOrder(1002,"FUTE",2,true);
        parkOrderRepository.save(parkOrder1);
        //when
        int staus = parkOrderRepository.updateparkOrder(1002,false);
        ParkOrder parkOrder2=parkOrderRepository.findById((long) 1002).get();
        //then
        Assertions.assertEquals(false,parkOrder2.isStatus());
    }

}
