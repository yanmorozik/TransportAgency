package eu.morozik.transportagency.service;

import eu.morozik.transportagency.api.dao.AddressDao;
import eu.morozik.transportagency.api.dao.DriverDao;
import eu.morozik.transportagency.api.service.AddressService;
import eu.morozik.transportagency.converter.AddressConverter;
import eu.morozik.transportagency.converter.DriverConverter;
import eu.morozik.transportagency.dto.AddressDto;
import eu.morozik.transportagency.model.Address;
import eu.morozik.transportagency.model.Content;
import eu.morozik.transportagency.model.Driver;
import eu.morozik.transportagency.specification.AddressSpecification;
import eu.morozik.transportagency.specification.ContentSpecification;
import eu.morozik.transportagency.specification.SearchCriteria;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {

    private final AddressDao addressDao;
    private final AddressConverter addressConverter;

    @Transactional
    @Override
    public AddressDto save(AddressDto addressDto) {
        Address address = addressConverter.convert(addressDto);
        Address response = addressDao.save(address);
        return addressConverter.convert(response);
    }

    @Transactional
    @Override
    public AddressDto findById(Long id) throws Exception {
        Address response = addressDao.findById(id).orElseThrow(Exception::new);
        return addressConverter.convert(response);
    }

    @Transactional
    @Override
    public List<AddressDto> findAll() {
        List<Address> addresses = addressDao.findAll();
        return addressConverter.convert(addresses);
    }

//    @Override
//    public AddressDto update(AddressDto addressDto) {
//        Address address = addressConverter.convert(addressDto);
//        Address response = addressDao.save(address);
//        return addressConverter.convert(response);
//    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        addressDao.deleteById(id);
    }

    @Transactional
    @Override
    public List<AddressDto> findByAnyOneFieldWithSpecification(String key, String operation, String value) {
        AddressSpecification addressSpecification = new AddressSpecification(new SearchCriteria(key,operation,value));
        List<Address> addresses = addressDao.findAll(addressSpecification);
        return addressConverter.convert(addresses);
    }
}
