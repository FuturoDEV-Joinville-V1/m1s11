package br.futurodev.joinville.m1s11.dtos.users;

import br.futurodev.joinville.m1s11.enums.UserRole;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserRequestDto {
    private String name;
    private String username;
    private String password;
    private UserRole role;
}
