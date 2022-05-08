package eu.morozik.transportagency.converter;

import eu.morozik.transportagency.dto.BookingWithRelationIdsDto;
import eu.morozik.transportagency.model.Booking;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class BookingConverterWithBookWithRelationIdsDto extends Converter<Booking, BookingWithRelationIdsDto>{
    public BookingConverterWithBookWithRelationIdsDto(ModelMapper modelMapper) {
        super(modelMapper);
    }
}
