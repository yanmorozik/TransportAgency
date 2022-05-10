package eu.morozik.transportagency.controller;

import eu.morozik.transportagency.api.service.TransportService;
import eu.morozik.transportagency.dto.transport.TransportDto;
import eu.morozik.transportagency.dto.transport.TransportWithRelationIdsDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/transports")
public class TransportController {

    private final TransportService transportService;

    @PostMapping
    @PreAuthorize("hasAuthority('drivers:write')")
    public TransportDto save(@RequestBody TransportWithRelationIdsDto transportWithRelationIdsDto) {
        return transportService.save(transportWithRelationIdsDto);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('drivers:write')")
    public TransportDto findById(@PathVariable Long id) throws Exception {
        return transportService.findById(id);
    }

    @GetMapping
    @PreAuthorize("hasAuthority('drivers:read')")
    public List<TransportDto> findAll() {
        return transportService.findAll();
    }

    @PutMapping
    @PreAuthorize("hasAuthority('drivers:write')")
    public TransportDto update(@RequestBody TransportWithRelationIdsDto transportWithRelationIdsDto) {
        return transportService.save(transportWithRelationIdsDto);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('drivers:write')")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        transportService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search")
    @PreAuthorize("hasAuthority('drivers:read')")
    public List<TransportDto> findByAnyFieldWithSpecification(@RequestParam String key,
                                                              @RequestParam String operation,
                                                              @RequestParam String value) {
        return transportService.findByAnyOneFieldWithSpecification(key, operation, value);
    }
}
