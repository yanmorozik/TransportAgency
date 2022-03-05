package eu.morozik.transportagency.api.dao;

import eu.morozik.transportagency.dto.DriverDto;
import eu.morozik.transportagency.model.Driver;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface DriverDao extends JpaRepository<Driver,Long>, JpaSpecificationExecutor<Driver> {

    Driver findByFirstName(String firstName);

}
