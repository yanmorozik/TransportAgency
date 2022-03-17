package eu.morozik.transportagency.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import eu.morozik.transportagency.api.service.DriverService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Collection;
import java.util.Collections;

import static eu.morozik.transportagency.ptototype.DriverPrototype.aDriverDto;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class DriverControllerTest {

    MockMvc mockMvc;
    ObjectMapper objectMapper;
    DriverService driverService;

    @BeforeEach
    void setUp() {
        driverService = mock(DriverService.class);
        mockMvc = MockMvcBuilders.standaloneSetup(new DriverController(driverService)).build();
        objectMapper = new ObjectMapper();
    }

    @Test
    void save() throws Exception {
        when(driverService.save(any())).thenReturn(aDriverDto());
        mockMvc.perform(post("/drivers")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(aDriverDto())))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(objectMapper.writeValueAsString(aDriverDto())));
    }

    @Test
    void findById() {
    }

    @Test
    void findAll() throws Exception {
        when(driverService.findAll()).thenReturn(Collections.singletonList(aDriverDto()));
        mockMvc.perform(get("/drivers")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(objectMapper.writeValueAsString(Collections.singletonList(aDriverDto()))))
                .andExpect(status().isOk());
    }

    @Test
    void deleteById() {
    }

    @Test
    void findByFirstName() {
    }

    @Test
    void findAllByFirstNameWithSpecification() {
    }
}