package com.rmmcosta.footballleague;

import com.rmmcosta.footballleague.config.SecurityConfig;
import com.rmmcosta.footballleague.entity.District;
import com.rmmcosta.footballleague.service.DistrictService;
import com.rmmcosta.footballleague.web.DistrictController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(DistrictController.class)
public class MockDistrictServiceUnitTests {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DistrictService districtService;

    @Test
    @WithMockUser(username = "xpto")
    public void getAllDistricts() throws Exception {
        mockMvc.perform(get("/district"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON))
                .andExpect(content().json("[]"));
        verify(districtService, times(1)).getAllDistricts();
    }

    @Test
    @WithMockUser(username = "xpto")
    public void getDistrict() throws Exception {
        mockMvc.perform(get("/district/1"))
                .andExpect(status().isOk());
        verify(districtService, times(1)).getDistrictById(1L);
    }

    @Test
    @WithMockUser(username = "admin")
    public void saveDistrict() throws Exception {
        mockMvc.perform(post("/district")
                        .contentType(APPLICATION_JSON)
                        .with(csrf())
                        .content("""
                                 {
                                  "id": "34",
                                  "name": "Algarve"
                                 }
                                """)
                )
                .andExpect(status().isCreated());
        verify(districtService, times(1)).saveDistrict(new District(34L, "Algarve"));
    }
}
