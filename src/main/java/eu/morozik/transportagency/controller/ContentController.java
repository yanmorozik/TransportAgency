package eu.morozik.transportagency.controller;

import eu.morozik.transportagency.api.service.ContentService;
import eu.morozik.transportagency.dto.ContentDto;
import eu.morozik.transportagency.dto.DriverDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("contents")
public class ContentController {

    private final ContentService contentService;

    @PostMapping
    public ContentDto save(@RequestBody ContentDto contentDto) {
        return contentService.save(contentDto);
    }

    @GetMapping("/{id}")
    public ContentDto findById(@PathVariable Long id) throws Exception {
        return contentService.findById(id);
    }

    @GetMapping
    public List<ContentDto> findAll() {
        return contentService.findAll();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        contentService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/findByAnyFieldWithSpecification")
    public List<ContentDto> findByAnyFieldWithSpecification(@RequestParam String key,
                                                            @RequestParam String operation,
                                                            @RequestParam String value) {
        return contentService.findByAnyFieldWithSpecification(key, operation, value);
    }
}
