package br.futurodev.joinville.m1s11.dtos.logins;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginRequestDto {
    private String username;
    private String password;
}
