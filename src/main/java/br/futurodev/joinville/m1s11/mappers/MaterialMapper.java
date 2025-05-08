package br.futurodev.joinville.m1s11.mappers;

import br.futurodev.joinville.m1s11.dtos.materials.MaterialRequestDto;
import br.futurodev.joinville.m1s11.dtos.materials.MaterialResponseDto;
import br.futurodev.joinville.m1s11.entities.Material;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper
public interface MaterialMapper {

    MaterialResponseDto toDto(Material material);
    Material toEntity(MaterialRequestDto dto, @MappingTarget Material material);

}
