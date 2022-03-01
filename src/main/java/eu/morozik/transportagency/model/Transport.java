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
@Table(name = "transports")
public class Transport extends BaseEntity {
    @Column(name="license_plate")
    private String licensePlate;

    @Column(name="color")
    private String color;

    @OneToMany(mappedBy = "transport")
    private Set<Content> contents = new HashSet<>();

    @OneToMany(mappedBy = "transport")
    private Set<Driver> drivers = new HashSet<>();

    @OneToOne
    @JoinColumn(name = "type_transport_id",referencedColumnName = "id")
    private TypeTransport typeTransport;

    @Enumerated(EnumType.STRING)
    private PurposeTransport purposeTransport;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "transport", cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.REFRESH,
            CascadeType.PERSIST})
    private Set<Booking> bookings = new HashSet<>();
}