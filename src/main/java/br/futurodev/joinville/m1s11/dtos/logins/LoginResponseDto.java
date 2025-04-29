package br.futurodev.joinville.m1s11.dtos.logins;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginResponseDto {

    private String type; // Basic / Bearer
    private String token; // token

}
