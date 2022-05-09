package eu.morozik.transportagency.api.service;

import eu.morozik.transportagency.dto.TypeTransportDto;
import eu.morozik.transportagency.dto.transport.TransportDto;
import eu.morozik.transportagency.dto.transport.TransportWithRelationIdsDto;

import java.util.List;

public interface TypeTransportService {
    TypeTransportDto save(TypeTransportDto typeTransportDto);

    TypeTransportDto findById(Long id) throws Exception;

    List<TypeTransportDto> findAll();

    void deleteById(Long id);
}
