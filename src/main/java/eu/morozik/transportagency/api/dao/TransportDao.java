package eu.morozik.transportagency.api.dao;

import eu.morozik.transportagency.model.Transport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface TransportDao extends JpaRepository<Transport, Long>, JpaSpecificationExecutor<Transport> {
}
