package eu.morozik.transportagency.converter;

import eu.morozik.transportagency.dto.AddressDto;
import eu.morozik.transportagency.model.Address;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class AddressConverter extends Converter<Address, AddressDto>{
    public AddressConverter(ModelMapper modelMapper) {
        super(modelMapper);
    }
}
