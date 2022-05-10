package eu.morozik.transportagency.converter;

import eu.morozik.transportagency.dto.transport.TransportWithRelationIdsDto;
import eu.morozik.transportagency.model.Transport;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class TransportConverterWithRelationIdsDto extends Converter<Transport, TransportWithRelationIdsDto> {
    public TransportConverterWithRelationIdsDto(ModelMapper modelMapper) {
        super(modelMapper);
    }
}
