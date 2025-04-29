package br.futurodev.joinville.m1s11.controllers;

import br.futurodev.joinville.m1s11.dtos.users.UserRequestDto;
import br.futurodev.joinville.m1s11.dtos.users.UserResponseDto;
import br.futurodev.joinville.m1s11.services.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("users")
public class UserController {

    private final UserService service;

    @GetMapping
    public List<UserResponseDto> get() {
        return service.findAll();
    }

    @GetMapping("{id}")
    public UserResponseDto getById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponseDto create(@Valid @RequestBody UserRequestDto dto) {
        return service.create(dto);
    }

    @PutMapping("{id}")
    public UserResponseDto update(@PathVariable Long id, @RequestBody UserRequestDto dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
