package com.tw.apistackbase.testParkOrderController;

import com.tw.apistackbase.Res.ParkOrderRes;
import com.tw.apistackbase.entity.ParkOrder;
import com.tw.apistackbase.respository.ParkOrderRepository;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ParkOrderControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ParkOrderRepository parkOrderRepository;
    @Autowired
    private ParkOrderRes parkOrderRes;
    @Test
    public void should_return_parkOrder_when_post_parkOrder_object() throws Exception {
        //given
        String jsonString = "{\n" +
                "\"oderNumber\":1001,\n" +
                "\"parkinglotName\":\"奔驰\",\n" +
                "\"carNumber\":1,\n" +
                "\"status\":true\n" +
                "}";
        //when
        ParkOrder parkOrder=new ParkOrder(1001,"奔驰",1,true);
        //then
        mockMvc.perform(MockMvcRequestBuilders.post("/parkOrders")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonString))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.oderNumber", Matchers.is(1001)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.parkinglotName",Matchers.is("奔驰")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.carNumber",Matchers.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.status",Matchers.is(true)));
    }
    @Test
    public void should_update_parkOrder_information_when_put_ordernumber_and_staus() throws Exception {
        //given
        String jsonString = "{\n" +
                "\"oderNumber\":1002,\n" +
                "\"parkinglotName\":\"AODI\",\n" +
                "\"carNumber\":2,\n" +
                "\"status\":false\n" +
                "}";
        //when
        ParkOrder parkOrder=new ParkOrder(1002,"AODI",2,false);
        //then
        mockMvc.perform(MockMvcRequestBuilders.put("/parkOrders/{orderNumber}")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonString))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.oderNumber", Matchers.is(1002)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.parkinglotName",Matchers.is("AODI")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.carNumber",Matchers.is(2)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.status",Matchers.is(false)));
    }
    @Test
    public  void should_get_exception_message_when_parkinglot_is_full() throws Exception {
        //given
        //when
        //then
        mockMvc.perform(MockMvcRequestBuilders.post("/parkOrders?id=1").content("停车场已经满"))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }



}
