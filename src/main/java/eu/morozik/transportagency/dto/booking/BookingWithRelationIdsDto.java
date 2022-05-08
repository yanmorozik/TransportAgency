package eu.morozik.transportagency.dto.booking;

import lombok.*;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingWithRelationIdsDto {

    private Long id;

    private LocalDateTime bookingData;

    private LocalDateTime deliveryDate;

    private Long transportId;

    private Long userId;

    private Long addressId;
}

