package eu.morozik.transportagency.model;

import lombok.*;

import javax.persistence.*;

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

    @OneToOne(fetch = FetchType.LAZY,mappedBy = "typeTransport")
    private Transport transport;

}
