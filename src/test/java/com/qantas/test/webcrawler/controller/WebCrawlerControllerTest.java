package com.qantas.test.webcrawler.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.UUID;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class WebCrawlerControllerTest {
    @Autowired
    private MockMvc mvc;

    @Test
    public void getLinks_Positive() throws Exception {

        String expectedResponse =
                "{\"url\":\"http://localhost:8080/testhtml\",\"title\":\"\",\"nodes\":[{\"url\":\"http://localhost:8080/testhtml/2\",\"title\":\"\",\"nodes\":[]},{\"url\":\"http://localhost:8080/testhtml/1\",\"title\":\"\",\"nodes\":[]},{\"url\":\"http://localhost:8080/testhtml/3\",\"title\":\"\",\"nodes\":[{\"url\":\"http://localhost:8080/testhtml/4\",\"title\":\"\",\"nodes\":[]}]}]}";
        mvc.perform(MockMvcRequestBuilders.get("/webcrawler?url=http://localhost:8080/testhtml").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
                //.andExpect(content().string(equalTo(expectedResponse)));
    }

    @Test
    public void getLinks_Empty_Response() throws Exception {

        String expectedResponse = "{\"url\":\"http://localhost:8080/testhtml/1\",\"title\":\"\",\"nodes\":[]}";
        mvc.perform(MockMvcRequestBuilders.get("/webcrawler?url=http://localhost:8080/testhtml/1").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
                //.andExpect(content().string(equalTo(expectedResponse)));
    }
}
