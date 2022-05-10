package eu.morozik.transportagency.api.service;

import eu.morozik.transportagency.dto.TypeTransportDto;

import java.util.List;

public interface TypeTransportService {
    TypeTransportDto save(TypeTransportDto typeTransportDto);

    TypeTransportDto findById(Long id) throws Exception;

    List<TypeTransportDto> findAll();

    void deleteById(Long id);

    List<TypeTransportDto> findByAnyOneFieldWithSpecification(String key, String operation, String value);
}
