package br.futurodev.joinville.m1s11.dtos.materials;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MaterialResponseDto {
    private Long id;
    private String name;
    private String description;
}
