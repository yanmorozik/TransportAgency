package eu.morozik.transportagency.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "drivers")
public class Driver extends BaseEntity {

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "surname")
    private String surname;

    @ManyToMany(fetch = FetchType.LAZY,mappedBy = "drivers",cascade = CascadeType.ALL)
    private Set<Transport> transports= new HashSet<>();
}
