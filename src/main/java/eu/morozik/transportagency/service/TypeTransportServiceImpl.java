package eu.morozik.transportagency.service;

import eu.morozik.transportagency.api.dao.TypeTransportDao;
import eu.morozik.transportagency.api.service.TypeTransportService;
import eu.morozik.transportagency.converter.TypeTransportConverter;
import eu.morozik.transportagency.dto.TypeTransportDto;
import eu.morozik.transportagency.model.TypeTransport;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TypeTransportServiceImpl implements TypeTransportService {
    private final TypeTransportDao typeTransportDao;
    private final TypeTransportConverter transportConverter;

    @Transactional
    @Override
    public TypeTransportDto save(TypeTransportDto typeTransportDto) {
        TypeTransport typeTransport = transportConverter.convert(typeTransportDto);
        TypeTransport response = typeTransportDao.save(typeTransport);
        return transportConverter.convert(response);
    }

    @Transactional
    @Override
    public TypeTransportDto findById(Long id) throws Exception {
        TypeTransport response = typeTransportDao.findById(id).orElseThrow(Exception::new);
        return transportConverter.convert(response);
    }

    @Transactional
    @Override
    public List<TypeTransportDto> findAll() {
        List<TypeTransport> typeTransports = typeTransportDao.findAll();
        return transportConverter.convert(typeTransports);
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        typeTransportDao.deleteById(id);
    }

}
