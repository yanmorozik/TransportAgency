package eu.morozik.transportagency.controller;

import eu.morozik.transportagency.api.service.BookingService;
import eu.morozik.transportagency.dto.booking.BookingDto;
import eu.morozik.transportagency.dto.booking.BookingWithRelationIdsDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/bookings")
public class BookingController {
    private final BookingService bookingService;

    @PostMapping
    @PreAuthorize("hasAuthority('drivers:write')")
    public BookingDto save(@RequestBody BookingWithRelationIdsDto bookingWithRelationIdsDto) {
        return bookingService.save(bookingWithRelationIdsDto);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('drivers:write')")
    public BookingDto findById(@PathVariable Long id) throws Exception {
        return bookingService.findById(id);
    }

    @GetMapping
    @PreAuthorize("hasAuthority('drivers:write')")
    public List<BookingDto> findAll() {
        return bookingService.findAll();
    }

    @PutMapping
    @PreAuthorize("hasAuthority('drivers:write')")
    public BookingDto update(@RequestBody BookingWithRelationIdsDto bookingWithRelationIdsDto) {
        return bookingService.save(bookingWithRelationIdsDto);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('drivers:write')")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        bookingService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
