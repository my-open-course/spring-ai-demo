package com.example;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.emptyOrNullString;
import static org.hamcrest.Matchers.not;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class DemoApplicationTests {

    @Resource
    private MockMvc mockMvc;

    @Test
    void contextLoads() {

    }

    @Test
    void helloApiTest() throws Exception {
        mockMvc.perform(get("/api/hello"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("Hello World"));
    }

    @Test
    void chatApiTest() throws Exception {
        mockMvc.perform(get("/api/chat"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(not(emptyOrNullString())));
    }
}
