package eu.morozik.transportagency.dto.transport;

import eu.morozik.transportagency.model.enums.PurposeTransport;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransportWithRelationIdsDto {
    private Long id;

    private String licensePlate;

    private String color;

    private Set<Long> contentIds = new HashSet<>();

    private Set<Long> driverIds = new HashSet<>();

    private Long typeTransportId;

    private Long purposeTransportId;
}
