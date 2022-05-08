package eu.morozik.transportagency.api.service;

import eu.morozik.transportagency.dto.transport.TransportDto;
import eu.morozik.transportagency.dto.transport.TransportWithRelationIdsDto;

import java.util.List;

public interface TransportService {

    TransportDto save(TransportWithRelationIdsDto transportWithRelationIdsDto);

    TransportDto findById(Long id) throws Exception;

    List<TransportDto> findAll();

    void deleteById(Long id);
}
