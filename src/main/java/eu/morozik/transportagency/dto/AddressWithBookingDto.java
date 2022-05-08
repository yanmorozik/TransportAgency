package eu.morozik.transportagency.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressWithBookingDto {
    private String country;

    private String city;
}
