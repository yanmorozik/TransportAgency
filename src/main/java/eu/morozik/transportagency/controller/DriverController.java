package eu.morozik.transportagency.controller;

import eu.morozik.transportagency.api.dao.DriverDao;
import eu.morozik.transportagency.api.service.DriverService;
import eu.morozik.transportagency.dto.DriverDto;
import eu.morozik.transportagency.model.Driver;
import eu.morozik.transportagency.specification.DriverSpecificationsBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
@RequiredArgsConstructor
@RequestMapping("drivers")
public class DriverController {

    @Autowired
    public DriverService driverService;

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

    @GetMapping("/findByFirstName/{firstname}")
    public DriverDto findByFirstName(@PathVariable String firstname) throws Exception {
        return driverService.findByFirstName(firstname);
    }

    @GetMapping("/search/filter")
    public List<Driver> search(@RequestParam String filter) {
        DriverSpecificationsBuilder builder = new DriverSpecificationsBuilder();
        Pattern pattern = Pattern.compile("(\\w+?)(:|<|>)(\\w+?),");
        Matcher matcher = pattern.matcher(filter + ",");
        while (matcher.find()) {
            builder.with(matcher.group(1), matcher.group(2), matcher.group(3));
        }

        Specification<Driver> spec = builder.build();
        return repo.findAll(spec);
    }
}
