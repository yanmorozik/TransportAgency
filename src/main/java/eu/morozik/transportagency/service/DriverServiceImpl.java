package eu.morozik.transportagency.service;

import eu.morozik.transportagency.api.dao.DriverDao;
import eu.morozik.transportagency.api.service.DriverService;
import eu.morozik.transportagency.converter.DriverConverter;
import eu.morozik.transportagency.dto.DriverDto;
import eu.morozik.transportagency.model.Driver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriverServiceImpl implements DriverService {

    @Autowired
    public DriverDao driverDao;

    @Autowired
    public DriverConverter driverConverter;

    @Override
    public DriverDto save(DriverDto driverDto) {
        Driver driver = driverConverter.convert(driverDto);
        Driver response = driverDao.save(driver);
        return driverConverter.convert(response);
    }

    @Override
    public DriverDto findById(Long id) throws Exception {
        Driver response = driverDao.findById(id).orElseThrow(Exception::new);
        return driverConverter.convert(response);
    }

    @Override
    public List<DriverDto> findAll() {
        List<Driver> drivers = driverDao.findAll();
        return driverConverter.convert(drivers);
    }

    @Override
    public void deleteById(Long id) {
        driverDao.deleteById(id);
    }

    @Override
    public DriverDto findByFirstName(String firstname) {
        Driver response = driverDao.findByFirstName(firstname);
        return driverConverter.convert(response);
    }
}
