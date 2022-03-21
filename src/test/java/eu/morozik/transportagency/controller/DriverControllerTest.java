package eu.morozik.transportagency.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import eu.morozik.transportagency.api.service.DriverService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Collections;

import static eu.morozik.transportagency.ptototype.DriverPrototype.aDriverDto;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class DriverControllerTest {

    MockMvc mockMvc;
    ObjectMapper objectMapper;

    @Mock
    DriverService driverService;

    @BeforeEach
    void setUp() {
        // MockitoAnnotations.openMocks(this);
        //driverService = mock(DriverService.class);
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
                .andExpect(content().json(objectMapper.writeValueAsString(aDriverDto())))
                .andExpect(jsonPath("$.firstName").value("test"));
    }

    @Test
    void findById() throws Exception {
        when(driverService.findById(any())).thenReturn(aDriverDto());
        mockMvc.perform(get("/drivers/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(aDriverDto())))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(objectMapper.writeValueAsString(aDriverDto())))
                .andExpect(jsonPath("$.id").value(1));
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
    void deleteById() throws Exception {
        //when(driverService.findById(any())).thenReturn(aDriverDto());
        mockMvc.perform(delete("/drivers/" + aDriverDto().getId()))
                .andExpect(status().isNoContent());
    }

    @Test
    void findByFirstName() throws Exception {
        //when(driverService.findByFirstName(any())).thenReturn(aDriverDto());
//        mockMvc.perform(get("/drivers")
//                .param("firstName", aDriverDto().getFirstName())
//                .contentType(MediaType.APPLICATION_JSON))
//                .andDo(print())
//                .andExpect(status().isOk())
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
//                .andExpect(jsonPath("$[0].firstName").value("test"));


//        mockMvc.perform(get("/drivers")
//                .param("firstName", aDriverDto().getFirstName()))
//                .andExpect(status().isOk())
//                .andDo(print());

        mockMvc.perform(get("/drivers")
                .param("firstName", aDriverDto().getFirstName())
        ).andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"));
    }

    @Test
    void findAllByFirstNameWithSpecification() throws Exception {
        when(driverService.findAll()).thenReturn(Collections.singletonList(aDriverDto()));
        mockMvc.perform(get("/drivers")
                .param("key", "firstName")
                .param("operation", ":")
                .param("value", "test")
        ).andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"));
    }
}