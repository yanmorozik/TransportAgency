package eu.morozik.transportagency.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@ToString
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

    @OneToOne(fetch = FetchType.LAZY,mappedBy = "address")
    private Booking booking;
}
