package eu.morozik.transportagency.dto.booking;

import eu.morozik.transportagency.dto.UserWithBookingDto;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookingDto {

    private Long id;

    private LocalDateTime bookingData;

    private LocalDateTime deliveryDate;

    private TransportWithBookingDto transport;

    private UserWithBookingDto user;

    private AddressWithBookingDto address;
}
