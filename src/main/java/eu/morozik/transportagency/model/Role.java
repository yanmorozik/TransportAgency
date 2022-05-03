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
@Table(name = "roles")
public class Role extends BaseEntity{
    @Column(name = "name_role")
    private String nameRole;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "roles",cascade = CascadeType.ALL)
    @ToString.Exclude
    private Set<User> users = new HashSet<>();
}
