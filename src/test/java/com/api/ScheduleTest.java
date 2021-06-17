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
	
    
    @Test
    public void hello가_리턴된다() throws Exception {
        mockMvc.perform(get("/v1/schedule/hello")
        		 .contentType(MediaType.TEXT_PLAIN))
                  .andExpect(status().isOk());
               // .andExpect((ResultMatcher) content().string("Hello"));
    }
    
    @Test
    public void scheduleApi테스트() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/v1/schedule/api/2001")
        		.contentType(MediaType.APPLICATION_JSON)
        		.accept(MediaType.APPLICATION_JSON))
        	    .andDo(print())
                .andExpect(status().isOk());
    }
 
}
