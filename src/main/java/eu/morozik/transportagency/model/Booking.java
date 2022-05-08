package eu.morozik.transportagency.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "bookings")
public class Booking extends BaseEntity {
    @Column(name = "booking_date")
    private LocalDateTime bookingData;

    @Column(name = "delivery_date")
    private LocalDateTime deliveryDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "transport_id")
    private Transport transport;

    @OneToOne(fetch = FetchType.LAZY,cascade =CascadeType.ALL,orphanRemoval = true)
    private Address address;

}
