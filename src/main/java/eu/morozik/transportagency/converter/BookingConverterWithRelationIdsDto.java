package eu.morozik.transportagency.converter;

import eu.morozik.transportagency.dto.booking.BookingWithRelationIdsDto;
import eu.morozik.transportagency.model.Booking;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class BookingConverterWithRelationIdsDto extends Converter<Booking, BookingWithRelationIdsDto> {
    public BookingConverterWithRelationIdsDto(ModelMapper modelMapper) {
        super(modelMapper);
    }
}
