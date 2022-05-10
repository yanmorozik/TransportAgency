package eu.morozik.transportagency.dto.transport;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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
