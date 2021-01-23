package com.galvanize.guestbook;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.galvanize.guestbook.bean.GuestEntry;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@WebMvcTest
public class GuestbookApplicationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    ObjectMapper mapper;
    GuestEntry request = new GuestEntry();

    @BeforeEach
    public void init(){
        request.setId(1);
        request.setName("Marie");
        request.setComments("Science rocks!");
    }


    @Test
    void test_getAllGuestBookEntries_returnList() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/entries"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(jsonPath("$.length()").value(1))
                .andExpect(jsonPath("$.[0].name").value("Abaram Lincoln"));

    }

    @Test
    void test_addEntry_returnsNewEntry() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/entries")
                .content(mapper.writeValueAsString(request))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(jsonPath("$.name").value("Marie"));

    }
}
