package com.example.testingweb.springboottestingweb;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.autoconfigure.web.servlet.*;
import org.springframework.boot.test.mock.mockito.*;
import org.springframework.test.web.servlet.*;

import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@WebMvcTest(GreetingController.class)
public class WebMockTest {

    @MockBean
    private GreetingService service;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void greetingShouldReturnMessageFromService() throws Exception {

        when(service.greet()).thenReturn("Hello, Mock");

        this.mockMvc.perform(get("/greeting"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("Hello, Mock")));
    }
}
