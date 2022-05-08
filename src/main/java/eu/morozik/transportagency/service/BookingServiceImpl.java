package eu.morozik.transportagency.service;

import eu.morozik.transportagency.api.dao.AddressDao;
import eu.morozik.transportagency.api.dao.BookingDao;
import eu.morozik.transportagency.api.dao.TransportDao;
import eu.morozik.transportagency.api.dao.UserDao;
import eu.morozik.transportagency.api.service.BookingService;
import eu.morozik.transportagency.converter.BookingConverter;
import eu.morozik.transportagency.converter.BookingConverterWithRelationIdsDto;
import eu.morozik.transportagency.dto.booking.BookingDto;
import eu.morozik.transportagency.dto.booking.BookingWithRelationIdsDto;
import eu.morozik.transportagency.exception.NotFoundException;
import eu.morozik.transportagency.model.Address;
import eu.morozik.transportagency.model.Booking;
import eu.morozik.transportagency.model.Transport;
import eu.morozik.transportagency.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {

    private final UserDao userDao;
    private final BookingDao bookingDao;
    private final AddressDao addressDao;
    private final TransportDao transportDao;
    private final BookingConverter bookingConverter;
    private final BookingConverterWithRelationIdsDto bookingWithRelationConverter;

    @Transactional
    @Override
    public BookingDto save(BookingWithRelationIdsDto bookingWithRelationIdsDto) {
        //Booking booking = bookingConverter.convert(bookingWithRelationIdsDto);
        Booking response = bookingDao.save(reassignment(bookingWithRelationIdsDto));
        return bookingConverter.convert(response);
    }

    @Transactional
    @Override
    public BookingDto findById(Long id) throws Exception {
        Booking response = bookingDao.findById(id).orElseThrow(Exception::new);
        return bookingConverter.convert(response);
    }

    @Transactional
    @Override
    public List<BookingDto> findAll() {
        List<Booking> bookings = bookingDao.findAll();
        return bookingConverter.convert(bookings);
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        bookingDao.deleteById(id);
    }


    public Booking reassignment(BookingWithRelationIdsDto bookingWithRelationIdsDto) {
        final Booking booking = bookingWithRelationConverter.convert(bookingWithRelationIdsDto);

        Transport transport = transportDao.findById(bookingWithRelationIdsDto.getTransportId())
                .orElseThrow(() -> new NotFoundException(bookingWithRelationIdsDto.getTransportId()));
        booking.setTransport(transport);

        User user = userDao.findById(bookingWithRelationIdsDto.getUserId())
                .orElseThrow(() -> new NotFoundException(bookingWithRelationIdsDto.getUserId()));
        booking.setUser(user);

        Address address = addressDao.findById(bookingWithRelationIdsDto.getAddressId())
                .orElseThrow(() -> new NotFoundException(bookingWithRelationIdsDto.getAddressId()));
        booking.setAddress(address);

        return booking;
    }
}
