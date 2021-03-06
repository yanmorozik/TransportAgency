package eu.morozik.transportagency.api.dao;

import eu.morozik.transportagency.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverDao extends JpaRepository<Driver, Long>, JpaSpecificationExecutor<Driver> {
    Driver findByFirstName(String firstName);
}
