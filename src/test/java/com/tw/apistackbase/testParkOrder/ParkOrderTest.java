package com.tw.apistackbase.testParkOrder;

import com.tw.apistackbase.entity.Car;
import com.tw.apistackbase.entity.Parkinglot;
import com.tw.apistackbase.respository.ParkOrderRepository;
import com.tw.apistackbase.respository.ParkinglotRepository;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ParkOrderTest {
    @Autowired
    private ParkOrderRepository parkOrderRepository;
    @Autowired
    private ParkinglotRepository parkinglotRepository;
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void should_add_order_when_parking_lot_not_full() throws Exception {
        //given
        parkinglotRepository.saveAndFlush(new Parkinglot("FUSSJ",10,"HOKONG"));
        Car car =new Car();
        car.setCarId(001);
        JSONObject jsonObject = new JSONObject(String.valueOf(car));
        //when//then
        this.mockMvc.perform(post("/parkOrders").content(jsonObject.toString())
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }

    @Test
    public void should_return_order_when_end_the__parking_order() throws Exception {
        //given
        parkinglotRepository.saveAndFlush(new Parkinglot("jeffrey parking lot",10,"Honkong"));
        Car car =new Car();
        car.setCarId(002);
        JSONObject jsonObject = new JSONObject(String.valueOf(car));
        //when
        this.mockMvc.perform(post("/parkOrders").content(jsonObject.toString())
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON));
        String result =  this.mockMvc.perform(patch("/parkOrders").content(jsonObject.toString())
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isAccepted()).andReturn().getResponse().getContentAsString();

        //then
        JSONObject jsonObject1 =new JSONObject(result);
        Assertions.assertEquals(false,jsonObject1.getInt("status"));

    }

    @Test
    public void should_return_erro_message_when_parking_the__full_parking_lot() throws Exception {
        //given
        parkinglotRepository.saveAndFlush(new Parkinglot("likes parking lot",0,"Honkong"));
        Car car =new Car();
        car.setCarId(1001);
        //when
        JSONObject jsonObject = new JSONObject(String.valueOf(car));
        //then
        try {
            String result =  this.mockMvc.perform(post("/parkOrders").content(jsonObject.toString())
                    .contentType(MediaType.APPLICATION_JSON)
                    .accept(MediaType.APPLICATION_JSON))
                    .andReturn().getResponse().getContentAsString();
        } catch (Exception e){
            Assertions.assertEquals("Request processing failed; nested exception is Exception(message=停车场已经满)",e.getMessage());
        }
    }
}