package eu.morozik.transportagency.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public enum Permission {
    DRIVERS_READ("drivers:read"),
    DRIVERS_WRITE("drivers:write");

    private final String permission;

    Permission(String permission) {
        this.permission = permission;
    }
}
