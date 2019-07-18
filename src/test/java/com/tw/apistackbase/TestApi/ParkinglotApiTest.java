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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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
    public  void should_delete_parkinglot_when_delete_parkinglot_by_id() throws Exception {
        //given
        mockMvc.perform(delete("/parkinglots/1")).andDo(print()).andExpect(MockMvcResultMatchers.status().isOk());
        //when
        //then
    }




}
