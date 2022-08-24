package com.gft.wineshop.controllerTests;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@ExtendWith(SpringExtension.class)
//@WebMvcTest(RegionController.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class RegionControllerTest{

    @Autowired
    private MockMvc mockMvc;
    @Test
    void testGetRegion() throws Exception{
        mockMvc.perform(get("/api/region/2").contentType(MediaType.APPLICATION_JSON))
                                  .andExpect(status().isOk())
                                  .andExpect(jsonPath("$.id",is(2)))
                                  .andExpect(jsonPath("$.country",is(("Espana"))));
    }

    @Test
    void testGetAllRegions() throws Exception{
        MvcResult result = mockMvc.perform(get("/api/regions").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
        String content = result.getResponse().getContentAsString();
        System.out.println(content);
    }

}
