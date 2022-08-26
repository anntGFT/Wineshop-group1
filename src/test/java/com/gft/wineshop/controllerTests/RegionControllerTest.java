package com.gft.wineshop.controllerTests;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gft.wineshop.models.Region;
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

    //"{\"name\":\"Inframundo\",\"country\":\"Espana\"}"
    @Test
    void testCreateRegion() throws Exception{
        Region region = new Region();
        region.setName("Vinlandia");
        region.setCountry("Noruega");
        mockMvc.perform(post("/api/region/create")
                .with(user("admin").roles("ADMIN"))
                .with(csrf())
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(region)))
                .andExpect(status().isOk());
    }
  /*  @Test
    void testCreateRegionwithId() throws Exception{
        Region region = new Region();
        region.setId(1);
        region.setName("Inframundo");
        region.setCountry("Espana");
        String regionString = asJsonString(region);
        System.out.println(region.getName()+region.getCountry());
        mockMvc.perform(post("/api/region/create")
                        .with(user("admin").roles("ADMIN"))
                        .with(csrf())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(region)))
                        .andExpect(status().isOk());
    }*/
    @Test
    void testDeleteRegion() throws Exception{
        mockMvc.perform(delete("/api/region/delete/{id}",132).contentType(MediaType.APPLICATION_JSON)
                        .with(user("admin").roles("ADMIN"))
                        .with(csrf()))
                        .andExpect(status().isOk());
    }
    @Test
    void testUpdateRegion() throws Exception{
        Region region = new Region();
        region.setName("Inframundo");
        region.setCountry("Espana");
        mockMvc.perform(put("/api/region/update/{id}",133)
                        .with(user("admin").roles("ADMIN"))
                        .with(csrf())
                        .content(asJsonString(region))
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
