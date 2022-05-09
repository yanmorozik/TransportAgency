package eu.morozik.transportagency.ptototype;

import eu.morozik.transportagency.dto.DriverDto;
import eu.morozik.transportagency.model.Driver;
import eu.morozik.transportagency.model.Transport;

public class DriverPrototype {

    public static Driver aDriver(){

        Driver driver = new Driver();
        driver.setId(1L);
        driver.setFirstName("test");
        driver.setSurname("test");

        Transport transport = new Transport();
       // driver.setTransport(transport);

        return driver;
    }

    public static DriverDto aDriverDto(){
        return DriverDto.builder()
                .id(1L)
                .firstName("test")
                .surname("test")
                .build();
    }
}
