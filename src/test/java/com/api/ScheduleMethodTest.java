package com.api;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.api.controller.ScheduleController;

@RunWith(SpringRunner.class)
@SpringBootTest // Register all beans to test. We can use @WebMvcTest to test as slice test. But this way is easy.
@AutoConfigureMockMvc
class ScheduleMethodTest {
    @Autowired // Enable to test cases because web server doesn't work
    MockMvc mockMvc;
    @Autowired
    ScheduleController scheduleController;

    @Test
    public void ischeckValid() throws Exception{
    //	scheduleController.isCheckPathVariable("2011");
    }
    

}
