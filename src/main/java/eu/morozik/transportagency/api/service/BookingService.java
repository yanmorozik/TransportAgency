package eu.morozik.transportagency.api.service;

import eu.morozik.transportagency.dto.booking.BookingDto;
import eu.morozik.transportagency.dto.booking.BookingWithRelationIdsDto;

import java.util.List;

public interface BookingService {

    BookingDto save(BookingWithRelationIdsDto bookingWithRelationIdsDto);

    BookingDto findById(Long id) throws Exception;

    List<BookingDto> findAll();

    void deleteById(Long id);
}
