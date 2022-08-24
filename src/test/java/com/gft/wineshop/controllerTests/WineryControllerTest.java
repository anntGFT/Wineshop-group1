package com.gft.wineshop.controllerTests;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gft.wineshop.models.Winery;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.hamcrest.Matchers.is;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class WineryControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void testGetWinery() throws Exception {
        mockMvc.perform(get("/api/winery/1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id",is(1)))
                .andExpect(jsonPath("$.name",is(("Teso La Monja"))));
    }

    @Test
    void testGetAllWineries() throws Exception{
        MvcResult result = mockMvc.perform(get("/api/wineries").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
        String content = result.getResponse().getContentAsString();
        System.out.println(content);
    }
    @Test
    void testCreateWinery() throws Exception{
        Winery winery = new Winery();
        winery.setName("testWinery");
        mockMvc.perform(post("/api/winery/create")
                        .with(user("admin").roles("ADMIN"))
                        .with(csrf())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(winery)))
                        .andExpect(status().isOk());
    }
    @Test
    void testDeleteWinery() throws Exception{
        mockMvc.perform(delete("/api/winery/delete/{id}",512)
                        .with(user("admin").roles("ADMIN"))
                        .with(csrf())
                        .contentType(MediaType.APPLICATION_JSON))
                        .andExpect(status().isOk());
    }
    @Test
    void testUpdateWinery() throws Exception{
        Winery winery = new Winery();
        winery.setName("Bastion de los inmortales");
        mockMvc.perform(put("/api/winery/update/{id}",32)
                        .with(user("admin").roles("ADMIN"))
                        .with(csrf())
                        .content(asJsonString(winery))
                        .contentType(MediaType.APPLICATION_JSON))
                        .andExpect(status().isOk());
    }
    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}