package eu.morozik.transportagency.service;

import eu.morozik.transportagency.api.dao.DriverDao;
import eu.morozik.transportagency.api.service.DriverService;
import eu.morozik.transportagency.converter.DriverConverter;
import eu.morozik.transportagency.dto.DriverDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;


import static eu.morozik.transportagency.ptototype.DriverPrototype.aDriver;
import static eu.morozik.transportagency.ptototype.DriverPrototype.aDriverDto;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class DriverServiceImplTest {

    private DriverDao driverDao;
    private DriverConverter driverConverter;
    private DriverService driverService;

    @BeforeEach
    void setUp() {
        driverDao = mock(DriverDao.class);
        driverConverter = new DriverConverter(new ModelMapper());
        driverService = new DriverServiceImpl(driverDao, driverConverter);
    }

    @Test
    void save() {
        when(driverDao.save(any())).thenReturn(aDriver());
        DriverDto createdDriver = driverService.save(aDriverDto());
        assertThat(createdDriver.getFirstName()).isEqualTo(aDriverDto().getFirstName());
    }

    @Test
    void findById() {
    }

    @Test
    void findAll() {
    }

    @Test
    void deleteById() {
    }

    @Test
    void findByFirstName() {
        when(driverDao.findByFirstName(eq("test"))).thenReturn(aDriver());
        DriverDto foundDriver= driverService.findByFirstName("test");
        assertThat(foundDriver.getFirstName()).isEqualTo("test");

    }

    @Test
    void findAllByFirstNameWithSpecification() {
    }
}