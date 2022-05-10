package eu.morozik.transportagency.api.dao;

import eu.morozik.transportagency.model.Booking;
import eu.morozik.transportagency.model.Content;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingDao extends JpaRepository<Booking,Long>, JpaSpecificationExecutor<Booking> {
}
