package eu.morozik.transportagency.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "addresses")
public class Address extends BaseEntity {
    @Column(name = "country")
    private String country;

    @Column(name = "city")
    private String city;

    @Column(name = "street")
    private String street;

    @Column(name = "house")
    private String house;

    @Column(name = "apartment")
    private Integer apartment;

    @OneToOne(mappedBy = "address", cascade ={CascadeType.PERSIST,CascadeType.REMOVE} , fetch = FetchType.LAZY)
    private Booking booking;
}
