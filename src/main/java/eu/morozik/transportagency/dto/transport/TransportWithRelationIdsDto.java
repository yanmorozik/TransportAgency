package eu.morozik.transportagency.dto.transport;

import eu.morozik.transportagency.model.enums.PurposeTransport;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransportWithRelationIdsDto {
    private Long id;

    private String licensePlate;

    private String color;

    private List<Long> contentIds;

    private List<Long> driverIds;

    private Long typeTransportId;

    private Long purposeTransportId;
}
