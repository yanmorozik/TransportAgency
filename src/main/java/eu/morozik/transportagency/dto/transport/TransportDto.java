package eu.morozik.transportagency.dto.transport;

import eu.morozik.transportagency.dto.ContentDto;
import eu.morozik.transportagency.dto.DriverDto;
import eu.morozik.transportagency.dto.TypeTransportDto;
import eu.morozik.transportagency.model.enums.PurposeTransport;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TransportDto {

    private Long id;

    private String licensePlate;

    private String color;

    private Set<ContentDto> contents = new HashSet<>();

    private Set<DriverDto> drivers = new HashSet<>();

    private TypeTransportDto typeTransport;

    private PurposeTransport purposeTransport;

}
