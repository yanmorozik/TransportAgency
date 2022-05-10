package eu.morozik.transportagency.service;

import eu.morozik.transportagency.api.dao.TypeTransportDao;
import eu.morozik.transportagency.api.service.TypeTransportService;
import eu.morozik.transportagency.converter.TypeTransportConverter;
import eu.morozik.transportagency.dto.TypeTransportDto;
import eu.morozik.transportagency.model.Transport;
import eu.morozik.transportagency.model.TypeTransport;
import eu.morozik.transportagency.specification.SearchCriteria;
import eu.morozik.transportagency.specification.TransportSpecification;
import eu.morozik.transportagency.specification.TypeTransportSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TypeTransportServiceImpl implements TypeTransportService {
    private final TypeTransportDao typeTransportDao;
    private final TypeTransportConverter typeTransportConverter;

    @Transactional
    @Override
    public TypeTransportDto save(TypeTransportDto typeTransportDto) {
        TypeTransport typeTransport = typeTransportConverter.convert(typeTransportDto);
        TypeTransport response = typeTransportDao.save(typeTransport);
        return typeTransportConverter.convert(response);
    }

    @Transactional
    @Override
    public TypeTransportDto findById(Long id) throws Exception {
        TypeTransport response = typeTransportDao.findById(id).orElseThrow(Exception::new);
        return typeTransportConverter.convert(response);
    }

    @Transactional
    @Override
    public List<TypeTransportDto> findAll() {
        List<TypeTransport> typeTransports = typeTransportDao.findAll();
        return typeTransportConverter.convert(typeTransports);
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        typeTransportDao.deleteById(id);
    }

    @Transactional
    @Override
    public List<TypeTransportDto> findByAnyOneFieldWithSpecification(String key, String operation, String value) {
        TypeTransportSpecification typeTransportSpecification = new TypeTransportSpecification(new SearchCriteria(key,operation,value));
        List<TypeTransport> typeTransports = typeTransportDao.findAll(typeTransportSpecification);
        return typeTransportConverter.convert(typeTransports);
    }

}
