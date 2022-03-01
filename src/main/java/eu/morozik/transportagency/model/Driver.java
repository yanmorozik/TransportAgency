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
@Table(name = "drivers")
public class Driver extends BaseEntity {
    @Column(name = "first_name")
    private String firstName;

    @Column(name = "surname")
    private String surName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    private Transport transport;
}
