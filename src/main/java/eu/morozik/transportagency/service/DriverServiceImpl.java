package eu.morozik.transportagency.service;

import eu.morozik.transportagency.api.dao.DriverDao;
import eu.morozik.transportagency.api.service.DriverService;
import eu.morozik.transportagency.converter.DriverConverter;
import eu.morozik.transportagency.dto.DriverDto;
import eu.morozik.transportagency.model.Driver;
import eu.morozik.transportagency.specification.DriverSpecification;
import eu.morozik.transportagency.specification.SearchCriteria;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DriverServiceImpl implements DriverService {

    private final DriverDao driverDao;
    private final DriverConverter driverConverter;

    @Transactional
    @Override
    public DriverDto save(DriverDto driverDto) {
        Driver driver = driverConverter.convert(driverDto);
        Driver response = driverDao.save(driver);
        return driverConverter.convert(response);
    }

    @Transactional
    @Override
    public DriverDto findById(Long id) throws Exception {
        Driver response = driverDao.findById(id).orElseThrow(Exception::new);
        return driverConverter.convert(response);
    }

    @Transactional
    @Override
    public List<DriverDto> findAll() {
        List<Driver> drivers = driverDao.findAll();
        return driverConverter.convert(drivers);
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        driverDao.deleteById(id);
    }

    @Transactional
    @Override
    public DriverDto findByFirstName(String firstname) {
        Driver response = driverDao.findByFirstName(firstname);
        return driverConverter.convert(response);
    }

    @Transactional
    @Override
    public List<DriverDto> findByAnyOneFieldWithSpecification(String key,String operation,String value) {
        DriverSpecification driverSpecification = new DriverSpecification(new SearchCriteria(key,operation,value));
        List<Driver> drivers = driverDao.findAll(driverSpecification);
        return driverConverter.convert(drivers);
    }
}
