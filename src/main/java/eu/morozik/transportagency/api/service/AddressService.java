package eu.morozik.transportagency.api.service;

import eu.morozik.transportagency.api.dao.AddressDao;
import eu.morozik.transportagency.dto.AddressDto;

import java.util.List;

public interface AddressService {
    AddressDto save(AddressDto addressDto);

    AddressDto findById(Long id) throws Exception;

    List<AddressDto> findAll();

//    AddressDto update (AddressDto addressDto);

    void deleteById(Long id);

}
