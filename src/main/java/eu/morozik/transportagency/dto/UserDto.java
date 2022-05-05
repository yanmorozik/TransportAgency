package eu.morozik.transportagency.dto;

import eu.morozik.transportagency.model.enums.Role;
import eu.morozik.transportagency.model.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private Long id;
    private String email;
    private String password;
    private String firstName;
    private String surname;
    private Role role;
    private Status status;
}
