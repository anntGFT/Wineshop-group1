package com.gft.wineshop.controllerTests;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gft.wineshop.models.Region;
import com.gft.wineshop.models.Type;
import com.gft.wineshop.models.Wine;
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
@AutoConfigureMockMvc // @WebMvcTest(WineryController.class)
class WineControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void testGetWine() throws Exception{
        mockMvc.perform(get("/api/wine/1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id",is(1)))
                .andExpect(jsonPath("$.name",is(("Tinto"))))
                .andExpect(jsonPath("$.year",is("2013")));
    }
    @Test
    void testGetAllWines() throws Exception{
        MvcResult result = mockMvc.perform(get("/api/wines")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
        String content = result.getResponse().getContentAsString();
        System.out.println(content);
    }
    @Test
    void testCreateWine() throws Exception{
        Wine wine = new Wine();
        wine.setName("Vegapunk");
        wine.setYear("2077");
        Winery wineryTest = new Winery();
        wineryTest.setId(512);
        wineryTest.setName("Bar de Moe");
        Type typeTest = new Type();
        typeTest.setId(32);
        typeTest.setName("Jackie Welles");
        Region regionTest = new Region();
        regionTest.setId(128);
        regionTest.setName("Pacifica");
        regionTest.setCountry("Night City");
        wine.setWinery(wineryTest);
        wine.setType(typeTest);
        wine.setRegion(regionTest);
        mockMvc.perform(post("/api/wine/create")
                        .with(user("user").roles("USER"))
                        .with(csrf())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(wine)))
                .andExpect(status().isOk());
    }
    @Test
    void testDeleteWine() throws Exception{
        mockMvc.perform(delete("/api/wine/delete/{id}",7501).contentType(MediaType.APPLICATION_JSON)
                        .with(user("user").roles("USER"))
                        .with(csrf()))
                .andExpect(status().isOk());
    }
    @Test
    void testUpdateWine() throws Exception{
        Wine wine = new Wine();
        wine.setName("Vegapunk");
        wine.setYear("2077");
        Winery wineryTest = new Winery();
        wineryTest.setId(12);
        wineryTest.setName("Vina Sastre");
        Type typeTest = new Type();
        typeTest.setId(3);
        typeTest.setName("Ribera del Duero Red");
        Region regionTest = new Region();
        regionTest.setId(2);
        regionTest.setName("Vino de Espana");
        regionTest.setCountry("Espana");
        wine.setWinery(wineryTest);
        wine.setType(typeTest);
        wine.setRegion(regionTest);
        mockMvc.perform(put("/api/wine/update/{id}",7502)
                        .with(user("user").roles("USER"))
                        .with(csrf())
                        .content(asJsonString(wine))
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