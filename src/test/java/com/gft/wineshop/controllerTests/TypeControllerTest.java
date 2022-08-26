package com.gft.wineshop.controllerTests;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gft.wineshop.models.Type;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class TypeControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void testGetType() throws Exception {
        mockMvc.perform(get("/api/type/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id",is(1)))
                .andExpect(jsonPath("$.name",is(("Toro Red"))));
    }
    @Test
    void testGetType_TypeNull() throws Exception{

        try {
            assertThrows(Exception.class, (Executable) mockMvc.perform(get("/api/type/0").contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isInternalServerError()));
        }catch(Exception e){

        }
        // asserThrows()
    }
    @Test
    void testGetAllTypes() throws Exception{
        MvcResult result = mockMvc.perform(get("/api/types")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
        String content = result.getResponse().getContentAsString();
        System.out.println(content);
    }
    @Test
    void testCreateType() throws Exception{
        Type type = new Type();
        type.setName("Jackie Welles");
        mockMvc.perform(post("/api/type/create")
                        .with(user("user").roles("USER"))
                        .with(csrf())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(type)))
                        .andExpect(status().isOk());
    }
    @Test
    void testDeleteType() throws Exception{
        mockMvc.perform(delete("/api/type/delete/{id}",35)
                        .with(user("admin").roles("ADMIN"))
                        .with(csrf())
                        .contentType(MediaType.APPLICATION_JSON))
                        .andExpect(status().isOk());
    }
    @Test
    void testUpdateType() throws Exception{
        Type type = new Type();
        type.setName("Culto de la oveja");
        mockMvc.perform(put("/api/type/update/{id}",32)
                        .with(user("admin").roles("ADMIN"))
                        .with(csrf())
                        .content(asJsonString(type))
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
