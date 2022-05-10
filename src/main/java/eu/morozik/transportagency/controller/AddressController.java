package eu.morozik.transportagency.controller;

import eu.morozik.transportagency.api.service.AddressService;
import eu.morozik.transportagency.api.service.DriverService;
import eu.morozik.transportagency.dto.AddressDto;
import eu.morozik.transportagency.dto.ContentDto;
import eu.morozik.transportagency.dto.DriverDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Locale;

@RestController
@RequiredArgsConstructor
@RequestMapping("/addresses")
public class AddressController {

    private final AddressService addressService;

    @PostMapping
    @PreAuthorize("hasAuthority('drivers:write')")
    public AddressDto save(@RequestBody AddressDto addressDto) {
        return addressService.save(addressDto);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('drivers:write')")
    public AddressDto findById(@PathVariable Long id) throws Exception {
        return addressService.findById(id);
    }

    @GetMapping
    @PreAuthorize("hasAuthority('drivers:read')")
    public List<AddressDto> findAll() {
        return addressService.findAll();
    }

    @PutMapping
    @PreAuthorize("hasAuthority('drivers:write')")
    public AddressDto update(@RequestBody AddressDto addressDto) {
        return addressService.save(addressDto);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('drivers:write')")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        addressService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search")
    @PreAuthorize("hasAuthority('drivers:read')")
    public List<AddressDto> findByAnyFieldWithSpecification(@RequestParam String key,
                                                            @RequestParam String operation,
                                                            @RequestParam String value) {
        return addressService.findByAnyOneFieldWithSpecification(key, operation, value);
    }
}
