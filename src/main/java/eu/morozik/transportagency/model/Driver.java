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

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY/*cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.REFRESH,
            CascadeType.PERSIST}*/ /*cascade = CascadeType.ALL*/)
    @JoinColumn(name = "id", updatable = false,insertable = false)
    private Transport transport;
}
