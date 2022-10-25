package com.rmmcosta.footballleague;

import com.rmmcosta.footballleague.service.TeamService;
import com.rmmcosta.footballleague.web.TeamController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(TeamController.class)
public class MockTeamServiceUnitTests {
    @Autowired
    WebApplicationContext context;
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    TeamService teamService;

    @WithMockUser(value = "xpto")
    @Test
    public void getAllTeams() throws Exception {
        mockMvc.perform(get("/team"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json("[]"));
        verify(teamService, times(1)).getAllTeams();
    }

    @WithMockUser(value = "xpto")
    @Test
    public void getTeam() throws Exception {
        mockMvc.perform(get("/team/1"))
                .andExpect(status().isOk());
        verify(teamService, times(1)).getTeamById(1L);
    }
}
