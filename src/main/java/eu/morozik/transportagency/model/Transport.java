package eu.morozik.transportagency.model;

import eu.morozik.transportagency.model.enums.PurposeTransport;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "transports")
public class Transport extends BaseEntity {
    @Column(name = "license_plate")
    private String licensePlate;

    @Column(name = "color")
    private String color;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.REFRESH,
            CascadeType.PERSIST}
    )
    @JoinTable(
            name = "transport_content",
            joinColumns = {@JoinColumn(name = "transport_id")},
            inverseJoinColumns = {@JoinColumn(name = "content_id")}
    )
    private Set<Content> contents = new HashSet<>();


    @ManyToMany(fetch = FetchType.LAZY, cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.REFRESH,
            CascadeType.PERSIST}
    )
    @JoinTable(
            name = "transport_driver",
            joinColumns = {@JoinColumn(name = "transport_id")},
            inverseJoinColumns = {@JoinColumn(name = "driver_id")}
    )
    private Set<Driver> drivers = new HashSet<>();


//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "transport",cascade = CascadeType.ALL,orphanRemoval = true)
//    @ToString.Exclude
//    private Set<Content> contents = new HashSet<>();

//    @OneToOne(fetch = FetchType.LAZY,mappedBy = "transport",cascade = {
//            CascadeType.DETACH,
//            CascadeType.MERGE,
//            CascadeType.REFRESH,
//            CascadeType.PERSIST})
//    @ToString.Exclude
//    private Driver driver;

    @ManyToOne(fetch = FetchType.LAZY/*, cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.REFRESH,
            CascadeType.PERSIST}*/)
    @JoinColumn(name = "type_transport_id"/*, referencedColumnName = "id"*/)
    private TypeTransport typeTransport;

    @Enumerated(EnumType.STRING)
    private PurposeTransport purposeTransport;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "transport", /*cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.REFRESH,
            CascadeType.PERSIST}*/cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.REFRESH,
            CascadeType.PERSIST})
    @ToString.Exclude
    private Set<Booking> bookings = new HashSet<>();
}
