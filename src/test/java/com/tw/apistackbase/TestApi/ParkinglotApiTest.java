package com.tw.apistackbase.TestApi;

import com.tw.apistackbase.ParkinglotRes;
import com.tw.apistackbase.entity.Parkinglot;
import com.tw.apistackbase.respository.ParkinglotRepository;
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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ParkinglotApiTest {
    @Autowired
    private MockMvc mockMvc;;
    @Autowired
    private ParkinglotRepository parkinglotRepository;
    @Autowired
    private ParkinglotRes parkinglotRes;
    @Test
    public void should_return_parkinglot_when_post_parkinglot_object() throws Exception {
        //given
        List<Parkinglot> mockList=new ArrayList<>();
        mockList.add(new Parkinglot("jijia",10,"hhshs"));
        //when
        Mockito.when(parkinglotRes.getParkinglots()).thenReturn(mockList);
        //then
        mockMvc.perform(post("/parkinglots")).andExpect(MockMvcResultMatchers.status().isOk());
    }
    @Test
    public  void should_delete_parkinglot_when_delete_parkinglot_by_id() throws Exception {
        //given
        //when
        //then
        mockMvc.perform(delete("/parkinglots/1")).andDo(print()).andExpect(MockMvcResultMatchers.status().isOk());
    }
    @Test
    public  void should_find_parkinglots_information_when_has_parkinglot_page_and_pagesize() throws Exception {
        //given
        List<Parkinglot> mockList=new ArrayList<>();
        Parkinglot parkinglot1=new Parkinglot(1,"parkone",10,"胡同");
        Parkinglot parkinglot2=new Parkinglot(2,"parktwo",10,"胡同1");
        Parkinglot parkinglot3=new Parkinglot(3,"parkthree",10,"胡同2");
        Parkinglot parkinglot4=new Parkinglot(4,"parkfour",10,"胡同3");
        mockList.add(parkinglot1);
        mockList.add(parkinglot2);
        mockList.add(parkinglot3);
        mockList.add(parkinglot4);
        //when
        Mockito.when(parkinglotRes.getParkinglots()).thenReturn(mockList);
        //then
        mockMvc.perform(get("/parkinglots?page=1&pagesize=15")).andDo(print()).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public  void should_find_parkinglot_information_when_has_parkinglot_by_id() throws Exception {
        //given
        List<Parkinglot> mockList=new ArrayList<>();
        Parkinglot parkinglot1=new Parkinglot(1,"parkone",10,"胡同");
        Parkinglot parkinglot2=new Parkinglot(2,"parktwo",10,"胡同1");
        Parkinglot parkinglot3=new Parkinglot(3,"parkthree",10,"胡同2");
        Parkinglot parkinglot4=new Parkinglot(4,"parkfour",10,"胡同3");
        mockList.add(parkinglot1);
        mockList.add(parkinglot2);
        mockList.add(parkinglot3);
        mockList.add(parkinglot4);
        //when
        Mockito.when(parkinglotRes.getParkinglots()).thenReturn(mockList);
        //then
        mockMvc.perform(get("/parkinglots/1")).andDo(print()).andExpect(MockMvcResultMatchers.status().isOk());
    }


}
