package com.tw.apistackbase.TestJpa;

import com.tw.apistackbase.entity.Parkinglot;
import com.tw.apistackbase.respository.ParkinglotRepository;
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
public class ParkinglotJpaTest {
    @Autowired
    private ParkinglotRepository parkinglotRepository;
    @Test
    public void should_return_size_when_the_add() {
        //given
        Parkinglot parkinglot1=new Parkinglot(1,"parkone",10,"胡同");
        parkinglotRepository.save(parkinglot1);
        Parkinglot parkinglot2=new Parkinglot(2,"parktwo",10,"胡同1");
        parkinglotRepository.save(parkinglot2);
        Parkinglot parkinglot3=new Parkinglot(3,"parkthree",10,"胡同2");
        parkinglotRepository.save(parkinglot3);
        Parkinglot parkinglot4=new Parkinglot(4,"parkfour",10,"胡同3");
        parkinglotRepository.save(parkinglot4);
        //when
        List<Parkinglot> parkinglots=parkinglotRepository.findAll();
        //then
        Assertions.assertEquals(4,parkinglots.size());
    }
    @Test
    public void should_delete_parkinglot_when_delete_parkinglot_case_by_id(){
        //given
        Parkinglot parkinglot1=new Parkinglot(1,"parkone",10,"胡同");
        parkinglotRepository.save(parkinglot1);
        Parkinglot parkinglot2=new Parkinglot(2,"parktwo",10,"胡同1");
        parkinglotRepository.save(parkinglot2);
        Parkinglot parkinglot3=new Parkinglot(3,"parkthree",10,"胡同2");
        parkinglotRepository.save(parkinglot3);
        Parkinglot parkinglot4=new Parkinglot(4,"parkfour",10,"胡同3");
        parkinglotRepository.save(parkinglot4);
        //when
        parkinglotRepository.deleteById(1);
        List<Parkinglot> parkinglots=parkinglotRepository.findAll();
        //then
        Assertions.assertEquals(3,parkinglots.size());
    }

    @Test
    public void should_can_add_when_property_null() {
        //given
        Parkinglot parkinglot=new Parkinglot();
        //when// /then
        Assertions.assertThrows(Exception.class,()->{
            parkinglotRepository.saveAndFlush(parkinglot);

        });
    }
    @Test
    public  void should_find_parkinglots_information_when_has_parkinglot_page_and_pagesize(){
        //given
        Parkinglot parkinglot1=new Parkinglot(1,"parkone",10,"胡同");
        parkinglotRepository.save(parkinglot1);
        Parkinglot parkinglot2=new Parkinglot(2,"parktwo",10,"胡同1");
        parkinglotRepository.save(parkinglot2);
        Parkinglot parkinglot3=new Parkinglot(3,"parkthree",10,"胡同2");
        parkinglotRepository.save(parkinglot3);
        //when
        List<Parkinglot> parkinglots=parkinglotRepository.findAllByPageAndPageSize(1,15);
        //then
        Assertions.assertEquals(3,parkinglots.size());
    }


}
