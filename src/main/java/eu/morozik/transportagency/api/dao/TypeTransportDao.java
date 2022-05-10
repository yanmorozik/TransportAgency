package eu.morozik.transportagency.api.dao;

import eu.morozik.transportagency.model.Content;
import eu.morozik.transportagency.model.TypeTransport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeTransportDao extends JpaRepository<TypeTransport,Long>, JpaSpecificationExecutor<TypeTransport> {
}
