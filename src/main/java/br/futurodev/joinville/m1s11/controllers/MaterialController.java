package br.futurodev.joinville.m1s11.controllers;

import br.futurodev.joinville.m1s11.dtos.materials.MaterialRequestDto;
import br.futurodev.joinville.m1s11.dtos.materials.MaterialResponseDto;
import br.futurodev.joinville.m1s11.services.MaterialService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("materials")
public class MaterialController {

    private final MaterialService service;

    @GetMapping
    public List<MaterialResponseDto> get() {
        return service.findAll();
    }

    @GetMapping("{id}")
    public MaterialResponseDto getById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MaterialResponseDto create(@Valid @RequestBody MaterialRequestDto dto) {
        return service.create(dto);
    }

    @PutMapping("{id}")
    public MaterialResponseDto update(@PathVariable Long id, @RequestBody MaterialRequestDto dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
