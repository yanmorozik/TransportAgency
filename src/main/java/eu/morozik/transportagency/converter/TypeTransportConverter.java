package eu.morozik.transportagency.converter;


import eu.morozik.transportagency.dto.TypeTransportDto;
import eu.morozik.transportagency.model.TypeTransport;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class TypeTransportConverter extends Converter<TypeTransport, TypeTransportDto> {
    public TypeTransportConverter(ModelMapper modelMapper) {
        super(modelMapper);
    }
}
