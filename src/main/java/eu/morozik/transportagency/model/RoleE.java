package eu.morozik.transportagency.model;

import lombok.Getter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public enum RoleE {

    USER_ROLE(Set.of(Permission.DRIVERS_READ)),
    ADMIN_ROLE(Set.of(Permission.DRIVERS_READ, Permission.DRIVERS_WRITE));

    private final Set<Permission> permissions;

    RoleE(Set<Permission> permissions) {
        this.permissions = permissions;
    }

    public Set<Permission> getPermissions() {
        return permissions;
    }

    public Set<SimpleGrantedAuthority> getAuthorities() {
        return getPermissions().stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());
    }

}
