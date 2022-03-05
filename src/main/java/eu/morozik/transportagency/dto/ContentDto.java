package eu.morozik.transportagency.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ContentDto {

    private Integer count;

    private Float weight;

    private Float height;

    private Float width;

    private String entityName;
}
