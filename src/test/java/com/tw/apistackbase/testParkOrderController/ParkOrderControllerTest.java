package com.tw.apistackbase.testParkOrderController;

import com.tw.apistackbase.Res.ParkOrderRes;
import com.tw.apistackbase.entity.ParkOrder;
import com.tw.apistackbase.respository.ParkOrderRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

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
        List<ParkOrder> mockList=new ArrayList<>();
        mockList.add(new ParkOrder(1001,"jijia",1,true));
        //when
        Mockito.when(parkOrderRes.getParkOrders()).thenReturn(mockList);
        //then
        mockMvc.perform(post("/parkorders")).andExpect(MockMvcResultMatchers.status().isOk());
    }

}
