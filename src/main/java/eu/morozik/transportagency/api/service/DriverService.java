package eu.morozik.transportagency.api.service;

import eu.morozik.transportagency.dto.DriverDto;

import java.util.List;

public interface DriverService {
    DriverDto save(DriverDto driverDto);

    DriverDto findById(Long id) throws Exception;

    List<DriverDto> findAll();

    void deleteById(Long id);

    DriverDto findByFirstName(String firstname);

    List<DriverDto> findAllByFirstNameInSpecification(String firstName);

    List<DriverDto> findAllByFirstNameWithSpecification(String key,String operation,String value) ;
}
