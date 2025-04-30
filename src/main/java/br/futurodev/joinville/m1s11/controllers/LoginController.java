package br.futurodev.joinville.m1s11.controllers;

import br.futurodev.joinville.m1s11.dtos.logins.LoginRequestDto;
import br.futurodev.joinville.m1s11.dtos.logins.LoginResponseDto;
import br.futurodev.joinville.m1s11.services.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("login")
public class LoginController {

    private final LoginService service;

    @GetMapping
    public Object login(@RequestHeader("Authorization") String token) {
        return service.getInfo(token);
    }

    @PostMapping
    public LoginResponseDto login(@RequestBody LoginRequestDto dto) {
        return service.authenticate(dto);
    }

}
