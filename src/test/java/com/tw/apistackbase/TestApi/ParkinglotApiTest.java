package com.tw.apistackbase.TestApi;

import com.tw.apistackbase.respository.ParkinglotRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ParkinglotApiTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ParkinglotRepository parkinglotRepository;
    @Test
    public void should_return_parkinglot_when_post_parkinglot_object(){


    }



}
