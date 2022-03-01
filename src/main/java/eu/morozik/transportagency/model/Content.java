package eu.morozik.transportagency.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

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
    private float weight;

    @Column(name = "height")
    private float height;

    @Column(name = "width")
    private float width;

    @Column(name = "entity_name")
    private float entityName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    private Transport transport;
}
