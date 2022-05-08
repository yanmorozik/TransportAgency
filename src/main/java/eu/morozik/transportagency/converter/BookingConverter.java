package eu.morozik.transportagency.converter;

import eu.morozik.transportagency.dto.booking.BookingDto;
import eu.morozik.transportagency.model.Booking;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class BookingConverter extends Converter<Booking, BookingDto> {
    public BookingConverter(ModelMapper modelMapper) {
        super(modelMapper);
    }
}
