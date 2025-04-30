package br.futurodev.joinville.m1s11.services;

import br.futurodev.joinville.m1s11.configs.JwtComponent;
import br.futurodev.joinville.m1s11.dtos.logins.LoginRequestDto;
import br.futurodev.joinville.m1s11.dtos.logins.LoginResponseDto;
import br.futurodev.joinville.m1s11.entities.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService {

    private final JwtComponent jwtComponent;
    private final AuthenticationManager authenticationManager;

    @Override
    public LoginResponseDto authenticate(LoginRequestDto dto) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        dto.getUsername(), dto.getPassword()
                )
        );

        if (authentication == null || !authentication.isAuthenticated()) {
            throw new BadCredentialsException("Invalid username or password");
        }

        User user = (User) authentication.getPrincipal();

        String token = jwtComponent.generateToken(user);
        return LoginResponseDto.builder().type("Bearer").token(token).build();
    }

    @Override
    public Object getInfo(String token) {
        return jwtComponent.parseClaims(
                token.split(" ")[1]
        ).getBody();
    }

}
