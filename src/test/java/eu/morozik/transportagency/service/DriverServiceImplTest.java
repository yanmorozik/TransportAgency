package eu.morozik.transportagency.service;

import eu.morozik.transportagency.api.dao.DriverDao;
import eu.morozik.transportagency.api.service.DriverService;
import eu.morozik.transportagency.converter.DriverConverter;
import eu.morozik.transportagency.dto.DriverDto;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.Collections;
import java.util.List;

import static eu.morozik.transportagency.ptototype.DriverPrototype.aDriver;
import static eu.morozik.transportagency.ptototype.DriverPrototype.aDriverDto;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class DriverServiceImplTest {

    @Mock
    private DriverDao driverDao;
    private DriverConverter driverConverter;
    private DriverService driverService;

    @BeforeEach
    void setUp() {
        //MockitoAnnotations.openMocks(this);
        driverConverter = new DriverConverter(new ModelMapper());
        driverService = new DriverServiceImpl(driverDao, driverConverter);
    }

    @DisplayName("test save method")
    @Tag("testTag")
    @Test
    void save() {
        when(driverDao.save(any())).thenReturn(aDriver());
        DriverDto createdDriver = driverService.save(aDriverDto());
        assertThat(createdDriver.getFirstName()).isEqualTo(aDriverDto().getFirstName());
    }

    @Test
    void findById() throws Exception {
        when(driverDao.findById(any())).thenReturn(java.util.Optional.of(aDriver()));
        DriverDto driverDto = driverService.findById(1L);
        assertThat(driverDto.getFirstName()).isEqualTo(aDriver().getFirstName());
        verify(driverDao, times(1)).findById(any());
    }

    @Test
    void findAll() {
        when(driverDao.findAll()).thenReturn(Collections.singletonList(aDriver()));
        List<DriverDto> driverList = driverService.findAll();
        assert (driverList.get(0).getFirstName().equals(aDriver().getFirstName()));
        verify(driverDao, times(1)).findAll();
    }

    @Test
    void deleteById() {
        doNothing().when(driverDao).deleteById(any());
        driverService.deleteById(1L);
        verify(driverDao, times(1)).deleteById(1L);
    }

    //@Disabled("test comment")
    @Test
    void findByFirstName() {
        when(driverDao.findByFirstName(eq("test"))).thenReturn(aDriver());
        DriverDto foundDriver = driverService.findByFirstName("test");
        assertThat(foundDriver.getFirstName()).isEqualTo("test");

    }

//    @Test
//    void findAllByFirstNameWithSpecification() {
//        when(driverDao.findAll(new DriverSpecification(new SearchCriteria("firstName",":","test"))))
//                .thenReturn(Collections.singletonList(aDriver()));
//        List<DriverDto> foundDriver = driverService.findAllByFirstNameWithSpecification("firstName",":","test");
//        assertThat(foundDriver.get(0).getFirstName()).isEqualTo("test");
//    }
}