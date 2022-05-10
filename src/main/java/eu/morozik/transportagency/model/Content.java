package eu.morozik.transportagency.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "contents")
public class Content extends BaseEntity {
    @Column(name = "count")
    private Integer count;

    @Column(name = "weight")
    private Float weight;

    @Column(name = "height")
    private Float height;

    @Column(name = "width")
    private Float width;

    @Column(name = "entity_name")
    private String entityName;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "contents", cascade = CascadeType.ALL)
    private Set<Transport> transports = new HashSet<>();
}
