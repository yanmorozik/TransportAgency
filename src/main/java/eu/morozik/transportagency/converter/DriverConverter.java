package eu.morozik.transportagency.converter;

import eu.morozik.transportagency.dto.DriverDto;
import eu.morozik.transportagency.model.Driver;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class DriverConverter extends Converter<Driver, DriverDto> {
    public DriverConverter(ModelMapper modelMapper) {
        super(modelMapper);
    }
}
