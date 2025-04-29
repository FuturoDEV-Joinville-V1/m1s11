package br.futurodev.joinville.m1s11.services;

import br.futurodev.joinville.m1s11.dtos.materials.MaterialRequestDto;
import br.futurodev.joinville.m1s11.dtos.materials.MaterialResponseDto;

import java.util.List;

public interface MaterialService {

    List<MaterialResponseDto> findAll();
    MaterialResponseDto findById(Long id);
    MaterialResponseDto create(MaterialRequestDto dto);
    MaterialResponseDto update(Long id, MaterialRequestDto dto);
    void delete(Long id);

}
