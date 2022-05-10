package eu.morozik.transportagency.controller;

import eu.morozik.transportagency.api.service.TypeTransportService;
import eu.morozik.transportagency.dto.TypeTransportDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/typeTransports")
public class TypeTransportController {
    private final TypeTransportService typeTransportService;

    @PostMapping
    @PreAuthorize("hasAuthority('drivers:write')")
    public TypeTransportDto save(@RequestBody TypeTransportDto typeTransportDto) {
        return typeTransportService.save(typeTransportDto);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('drivers:write')")
    public TypeTransportDto findById(@PathVariable Long id) throws Exception {
        return typeTransportService.findById(id);
    }

    @GetMapping
    @PreAuthorize("hasAuthority('drivers:write')")
    public List<TypeTransportDto> findAll() {
        return typeTransportService.findAll();
    }

    @PutMapping
    @PreAuthorize("hasAuthority('drivers:write')")
    public TypeTransportDto update(@RequestBody TypeTransportDto typeTransportDto) {
        return typeTransportService.save(typeTransportDto);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('drivers:write')")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        typeTransportService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search")
    public List<TypeTransportDto> findAllByFirstNameWithSpecification(@RequestParam String key,
                                                                      @RequestParam String operation,
                                                                      @RequestParam String value) {
        return typeTransportService.findByAnyOneFieldWithSpecification(key, operation, value);
    }
}
