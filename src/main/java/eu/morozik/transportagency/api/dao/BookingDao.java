package eu.morozik.transportagency.api.dao;

import eu.morozik.transportagency.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingDao extends JpaRepository<Booking,Long> {
}
