package br.futurodev.joinville.m1s11.mappers;

import br.futurodev.joinville.m1s11.dtos.materials.MaterialRequestDto;
import br.futurodev.joinville.m1s11.dtos.materials.MaterialResponseDto;
import br.futurodev.joinville.m1s11.entities.Material;

import java.util.List;

public class MaterialMapper {

    private MaterialMapper() {}

    public static MaterialResponseDto toDto(Material material) {
        return MaterialResponseDto.builder()
                .id(material.getId())
                .name(material.getName())
                .description(material.getDescription())
                .build();
    }

    public static List<MaterialResponseDto> toDtos(List<Material> materials) {
        return materials.stream()
                .map(MaterialMapper::toDto)
                .toList();
    }

    public static Material toEntity(Material material, MaterialRequestDto dto) {
        material.setName(dto.getName());
        material.setDescription(dto.getDescription());
        return material;
    }

}
