package eu.morozik.transportagency.controller;

import eu.morozik.transportagency.api.service.DriverService;
import eu.morozik.transportagency.dto.ContentDto;
import eu.morozik.transportagency.dto.DriverDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/drivers")
public class DriverController {

    private final DriverService driverService;

    @PostMapping
    @PreAuthorize("hasAuthority('drivers:write')")
    public DriverDto save(@RequestBody DriverDto driverDto) {
        return driverService.save(driverDto);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('drivers:write')")
    public DriverDto findById(@PathVariable Long id) throws Exception {
        return driverService.findById(id);
    }

    @GetMapping
    @PreAuthorize("hasAuthority('drivers:read')")
    public List<DriverDto> findAll() {
        return driverService.findAll();
    }

    @PutMapping
    @PreAuthorize("hasAuthority('drivers:write')")
    public DriverDto update(@RequestBody DriverDto driverDto) {
        return driverService.save(driverDto);
    }


    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('drivers:write')")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        driverService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/findByFirstName")
    @PreAuthorize("hasAuthority('drivers:read')")
    public DriverDto findByFirstName(@RequestParam String firstName) throws Exception {
        return driverService.findByFirstName(firstName);
    }

    @GetMapping("/search")
    public List<DriverDto> findAllByFirstNameWithSpecification(@RequestParam String key,
                                                               @RequestParam String operation,
                                                               @RequestParam String value) {
        return driverService.findByAnyOneFieldWithSpecification(key,operation,value);
    }
}
