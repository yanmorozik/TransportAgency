package eu.morozik.transportagency.service;

import eu.morozik.transportagency.api.dao.ContentDao;
import eu.morozik.transportagency.api.dao.DriverDao;
import eu.morozik.transportagency.api.dao.TransportDao;
import eu.morozik.transportagency.api.dao.TypeTransportDao;
import eu.morozik.transportagency.api.service.TransportService;
import eu.morozik.transportagency.converter.BookingConverter;
import eu.morozik.transportagency.converter.BookingConverterWithRelationIdsDto;
import eu.morozik.transportagency.converter.TransportConverter;
import eu.morozik.transportagency.converter.TransportConverterWithRelationIdsDto;
import eu.morozik.transportagency.dto.booking.BookingDto;
import eu.morozik.transportagency.dto.booking.BookingWithRelationIdsDto;
import eu.morozik.transportagency.dto.transport.TransportDto;
import eu.morozik.transportagency.dto.transport.TransportWithRelationIdsDto;
import eu.morozik.transportagency.exception.NotFoundException;
import eu.morozik.transportagency.model.*;
import eu.morozik.transportagency.model.enums.PurposeTransport;
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


    public Transport reassignment(TransportWithRelationIdsDto transportWithRelationIdsDto) {
        final Transport transport = transportWithRelationConverter.convert(transportWithRelationIdsDto);

        Set<Content> contents =transportWithRelationIdsDto.getContentIds()
                .stream()
                .map(id->contentDao.findById(id).orElseThrow(() -> new NotFoundException(id)))
                .collect(Collectors.toSet());

        transport.setContents(contents);

        Set<Driver>drivers=transportWithRelationIdsDto.getDriverIds()
                .stream()
                .map(id->driverDao.findById(id).orElseThrow(()->new NotFoundException(id)))
                .collect(Collectors.toSet());

        transport.setDrivers(drivers);

        TypeTransport typeTransport=typeTransportDao.findById(transportWithRelationIdsDto.getTypeTransportId())
                .orElseThrow(()->new NotFoundException(transportWithRelationIdsDto.getTypeTransportId()));

        transport.setTypeTransport(typeTransport);

        PurposeTransport purposeTransport = PurposeTransport.MIXED;

        transport.setPurposeTransport(purposeTransport);

        return transport;
    }
}
