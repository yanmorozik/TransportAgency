package eu.morozik.transportagency.model.enums;

import eu.morozik.transportagency.model.enums.Permission;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public enum Role {
    //new HashSet<>(Arrays.asList("a", "b"));


    USER(new HashSet<Permission> (Collections.singletonList(Permission.DRIVERS_READ))),
    ADMIN(new HashSet<Permission>(Arrays.asList(Permission.DRIVERS_READ,Permission.DRIVERS_WRITE)));

    private final Set<Permission> permissions;

    Role(Set<Permission> permissions) {
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

    public static Role getRole(Long i){
        if (i==1)
            return USER;
        if (i==2)
            return ADMIN;
        return null;
    }
}
