package com.galvanize.guestbook;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.galvanize.guestbook.bean.GuestEntry;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@WebMvcTest
public class GuestbookApplicationTest {

    @Autowired
    private ObjectMapper mapper;

    private GuestEntry request = new GuestEntry();

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    public void init() {
        request.setId(1);
        request.setName("Marie");
        request.setComments("Science rocks!");
    }

    @Test
    void test_getAllGuestBookEntries_returnEmptyList() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/entries"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(jsonPath("$.*", hasSize(0)));

    }

    @Test
    void test_addEntry_returnsNewEntry() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/entries")
                .content(mapper.writeValueAsString(request))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(jsonPath("$.name").value("Marie"));

    }

    @Test
    void test_getAllGuestBookEntries_returnList() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/entries"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(jsonPath("$.*", hasSize(1)))
                .andExpect(jsonPath("$.[0].name").value("Marie"));

    }
}
