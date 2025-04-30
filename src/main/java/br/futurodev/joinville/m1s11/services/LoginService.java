package br.futurodev.joinville.m1s11.services;

import br.futurodev.joinville.m1s11.dtos.logins.LoginRequestDto;
import br.futurodev.joinville.m1s11.dtos.logins.LoginResponseDto;
import br.futurodev.joinville.m1s11.dtos.users.UserRequestDto;
import br.futurodev.joinville.m1s11.dtos.users.UserResponseDto;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface LoginService {

    LoginResponseDto authenticate(LoginRequestDto dto);
    Object getInfo(String token);

}
