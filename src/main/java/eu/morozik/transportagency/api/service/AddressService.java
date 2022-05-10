package eu.morozik.transportagency.api.service;

import eu.morozik.transportagency.api.dao.AddressDao;
import eu.morozik.transportagency.dto.AddressDto;
import eu.morozik.transportagency.dto.ContentDto;

import java.util.List;

public interface AddressService {
    AddressDto save(AddressDto addressDto);

    AddressDto findById(Long id) throws Exception;

    List<AddressDto> findAll();

    void deleteById(Long id);

    List<AddressDto> findByAnyOneFieldWithSpecification(String key, String operation, String value);
}
