package com.api;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest // Register all beans to test. We can use @WebMvcTest to test as slice test. But this way is easy.
@AutoConfigureMockMvc
class ScheduleTest {
    @Autowired // Enable to test cases because web server doesn't work
    MockMvc mockMvc;
    
//    @Test
//    public void 날짜3자리넣었을시() throws Exception {
//        mockMvc.perform(MockMvcRequestBuilders.get("/v1/schedule/api/200")
//        		.contentType(MediaType.APPLICATION_JSON)
//        		.accept(MediaType.APPLICATION_JSON))
//        	    .andDo(print())
//                .andExpect(status().isOk());
//    }

    @Test
    public void scheduleApi_상태200() throws Exception {
        mockMvc.perform(get("/v1/schedule/api/{yyyymm}/{ldport}/{dcport}","201105","ggggg","ddgdd")
        		.contentType(MediaType.TEXT_PLAIN)
        		.accept(MediaType.APPLICATION_JSON))
        	    .andDo(print())
                .andExpect(status().isOk());
    }

    
//    @Test
//    public void yyyymm_2011일시_오류처리() throws Exception {
//        mockMvc.perform(MockMvcRequestBuilders.get("/v1/schedule/api/2011")
//        		.contentType(MediaType.APPLICATION_JSON)
//        		.accept(MediaType.APPLICATION_JSON))
//        	    .andDo(print())
//                .andExpect(status().isOk());
//    }
 
}
