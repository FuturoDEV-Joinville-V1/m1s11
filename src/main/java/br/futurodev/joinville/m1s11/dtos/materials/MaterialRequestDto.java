package br.futurodev.joinville.m1s11.dtos.materials;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MaterialRequestDto {
    @NotBlank
    private String name;
    private String description;
}
