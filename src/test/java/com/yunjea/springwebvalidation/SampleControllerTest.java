package com.yunjea.springwebvalidation;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest
public class SampleControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    public void hey_age() throws Exception {
        mockMvc.perform(get("/hey")
                .param("name", "yunjae")
                .param("age", "-45"))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void hey_name() throws Exception {
        mockMvc.perform(get("/hey")
                .param("name", "")
                .param("age", "45"))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void hey() throws Exception {
        mockMvc.perform(get("/hey")
                .param("name", "yunjae")
                .param("age", "45"))
                .andExpect(status().isOk());
    }
}
