package eu.morozik.transportagency.api.dao;

import eu.morozik.transportagency.model.Driver;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static eu.morozik.transportagency.ptototype.DriverPrototype.aDriver;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
class DriverDaoTest {

    @Autowired
    private DriverDao driverDao;

    @Test
    void findByFirstName() {
        driverDao.save(aDriver());
        Driver foundDriver = driverDao.findByFirstName(aDriver().getFirstName());
        assertThat(foundDriver).isNotNull();
        assertThat(foundDriver.getSurname()).isEqualTo(aDriver().getSurname());
    }
}