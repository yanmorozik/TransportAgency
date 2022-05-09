package eu.morozik.transportagency.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "types_transport")
public class TypeTransport extends BaseEntity {

    @Column(name = "type_name")
    private String typeName;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "typeTransport",cascade = CascadeType.ALL,orphanRemoval = true)
    private Set<Transport> transports= new HashSet<>();

}
