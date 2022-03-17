package eu.morozik.transportagency.controller;

import eu.morozik.transportagency.api.service.DriverService;
import eu.morozik.transportagency.dto.DriverDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("drivers")
public class DriverController {

    private final DriverService driverService;

    @PostMapping
    public DriverDto save(@RequestBody DriverDto driverDto) {
        return driverService.save(driverDto);
    }

    @GetMapping("/{id}")
    public DriverDto findById(@PathVariable Long id) throws Exception {
        return driverService.findById(id);
    }

    @GetMapping
    public List<DriverDto> findAll() {
        return driverService.findAll();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        driverService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/findByFirstName/{firstName}")
    public DriverDto findByFirstName(@PathVariable String firstName) throws Exception {
        return driverService.findByFirstName(firstName);
    }

    @GetMapping("/findAllByFirstNameInSpecificationWithSpecification")
    public List<DriverDto> findAllByFirstNameWithSpecification(@RequestParam String key,
                                                               @RequestParam String operation,
                                                               @RequestParam String value) {
        return driverService.findAllByFirstNameWithSpecification(key,operation,value);
    }


}
