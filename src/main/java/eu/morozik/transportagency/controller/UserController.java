package eu.morozik.transportagency.controller;

import eu.morozik.transportagency.api.service.UserService;
import eu.morozik.transportagency.dto.UserDto;
import eu.morozik.transportagency.dto.UserWithRelationIdsDto;
import eu.morozik.transportagency.dto.transport.TransportDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('drivers:write')")
    public UserDto findById(@PathVariable Long id) throws Exception {
        return userService.findById(id);
    }

    @GetMapping
    @PreAuthorize("hasAuthority('drivers:write')")
    public List<UserDto> findAll() {
        return userService.findAll();
    }

    @PutMapping
    @PreAuthorize("hasAuthority('drivers:write')")
    public UserDto update(@RequestBody UserWithRelationIdsDto userWithRelationIdsDto) {
        return userService.update(userWithRelationIdsDto);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('drivers:write')")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        userService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search")
    @PreAuthorize("hasAuthority('drivers:read')")
    public List<UserDto> findByAnyFieldWithSpecification(@RequestParam String key,
                                                              @RequestParam String operation,
                                                              @RequestParam String value) {
        return userService.findByAnyOneFieldWithSpecification(key, operation, value);
    }
}
