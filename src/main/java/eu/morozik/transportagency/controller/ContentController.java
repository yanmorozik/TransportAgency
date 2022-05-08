package eu.morozik.transportagency.controller;

import eu.morozik.transportagency.api.service.ContentService;
import eu.morozik.transportagency.dto.BookingDto;
import eu.morozik.transportagency.dto.BookingWithRelationIdsDto;
import eu.morozik.transportagency.dto.ContentDto;
import eu.morozik.transportagency.dto.DriverDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/contents")
public class ContentController {

    private final ContentService contentService;

    @PostMapping
    @PreAuthorize("hasAuthority('drivers:write')")
    public ContentDto save(@RequestBody ContentDto contentDto) {
        return contentService.save(contentDto);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('drivers:write')")
    public ContentDto findById(@PathVariable Long id) throws Exception {
        return contentService.findById(id);
    }

    @GetMapping
    @PreAuthorize("hasAuthority('drivers:write')")
    public List<ContentDto> findAll() {
        return contentService.findAll();
    }

    @PutMapping
    @PreAuthorize("hasAuthority('drivers:write')")
    public ContentDto update(@RequestBody ContentDto contentDto) {
        return contentService.save(contentDto);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('drivers:write')")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        contentService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/findByAnyFieldWithSpecification")
    @PreAuthorize("hasAuthority('drivers:read')")
    public List<ContentDto> findByAnyFieldWithSpecification(@RequestParam String key,
                                                            @RequestParam String operation,
                                                            @RequestParam String value) {
        return contentService.findByAnyFieldWithSpecification(key, operation, value);
    }
}
