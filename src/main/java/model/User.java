package model;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.management.relation.Role;
import java.time.LocalDateTime;
import java.util.Set;

@AllArgsConstructor
@Data

public class User {
    private String login;
    private String password;
    private Set<Role> roles;
    private LocalDateTime registrationDateTime;
    private boolean status;
    private int probes;

}
