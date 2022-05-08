package eu.morozik.transportagency.api.service;

import eu.morozik.transportagency.dto.BookingDto;
import eu.morozik.transportagency.dto.BookingWithRelationIdsDto;

import java.util.List;

public interface BookingService {

    BookingDto save(BookingWithRelationIdsDto bookingWithRelationIdsDto);

    BookingDto findById(Long id) throws Exception;

    List<BookingDto> findAll();

    void deleteById(Long id);
}
