package eu.morozik.transportagency.service;

import eu.morozik.transportagency.api.dao.ContentDao;
import eu.morozik.transportagency.api.dao.DriverDao;
import eu.morozik.transportagency.api.dao.TransportDao;
import eu.morozik.transportagency.api.dao.TypeTransportDao;
import eu.morozik.transportagency.api.service.TransportService;
import eu.morozik.transportagency.converter.TransportConverter;
import eu.morozik.transportagency.converter.TransportConverterWithRelationIdsDto;
import eu.morozik.transportagency.dto.transport.TransportDto;
import eu.morozik.transportagency.dto.transport.TransportWithRelationIdsDto;
import eu.morozik.transportagency.exception.NotFoundException;
import eu.morozik.transportagency.model.Content;
import eu.morozik.transportagency.model.Driver;
import eu.morozik.transportagency.model.Transport;
import eu.morozik.transportagency.model.TypeTransport;
import eu.morozik.transportagency.model.enums.PurposeTransport;
import eu.morozik.transportagency.specification.SearchCriteria;
import eu.morozik.transportagency.specification.TransportSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TransportServiceImpl implements TransportService {

    private final TransportDao transportDao;
    private final ContentDao contentDao;
    private final DriverDao driverDao;
    private final TypeTransportDao typeTransportDao;
    private final TransportConverter transportConverter;
    private final TransportConverterWithRelationIdsDto transportWithRelationConverter;

    @Transactional
    @Override
    public TransportDto save(TransportWithRelationIdsDto transportWithRelationIdsDto) {
        Transport response = transportDao.save(reassignment(transportWithRelationIdsDto));
        return transportConverter.convert(response);
    }

    @Transactional
    @Override
    public TransportDto findById(Long id) throws Exception {
        Transport response = transportDao.findById(id).orElseThrow(Exception::new);
        return transportConverter.convert(response);
    }

    @Transactional
    @Override
    public List<TransportDto> findAll() {
        List<Transport> transports = transportDao.findAll();
        return transportConverter.convert(transports);
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        transportDao.deleteById(id);
    }

    @Transactional
    @Override
    public List<TransportDto> findByAnyOneFieldWithSpecification(String key, String operation, String value) {
        TransportSpecification transportSpecification = new TransportSpecification(new SearchCriteria(key, operation, value));
        List<Transport> transports = transportDao.findAll(transportSpecification);
        return transportConverter.convert(transports);
    }


    public Transport reassignment(TransportWithRelationIdsDto transportWithRelationIdsDto) {
        final Transport transport = transportWithRelationConverter.convert(transportWithRelationIdsDto);


        Set<Content> contents = transportWithRelationIdsDto.getContentIds()
                .stream()
                .map(id -> contentDao.findById(id).orElseThrow(() -> new NotFoundException(id)))
                .collect(Collectors.toSet());

        transport.setContents(contents);

        Set<Driver> drivers = transportWithRelationIdsDto.getDriverIds()
                .stream()
                .map(id -> driverDao.findById(id).orElseThrow(() -> new NotFoundException(id)))
                .collect(Collectors.toSet());

        transport.setDrivers(drivers);

        TypeTransport typeTransport = typeTransportDao.findById(transportWithRelationIdsDto.getTypeTransportId())
                .orElseThrow(() -> new NotFoundException(transportWithRelationIdsDto.getTypeTransportId()));

        transport.setTypeTransport(typeTransport);

        transport.setPurposeTransport(PurposeTransport.getPurposeTransport(transportWithRelationIdsDto.getPurposeTransportId()));

        return transport;
    }
}
