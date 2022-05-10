package eu.morozik.transportagency.converter;

import eu.morozik.transportagency.dto.transport.TransportDto;
import eu.morozik.transportagency.model.Transport;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class TransportConverter extends Converter<Transport, TransportDto> {
    public TransportConverter(ModelMapper modelMapper) {
        super(modelMapper);
    }
}
