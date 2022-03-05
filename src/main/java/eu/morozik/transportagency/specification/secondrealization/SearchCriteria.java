package eu.morozik.transportagency.specification.secondrealization;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
public class SearchCriteria {
    private String key;
    private String operation;
    private Object value;
}
