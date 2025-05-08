package br.futurodev.joinville.m1s11.services;

import br.futurodev.joinville.m1s11.dtos.materials.MaterialRequestDto;
import br.futurodev.joinville.m1s11.dtos.materials.MaterialResponseDto;
import br.futurodev.joinville.m1s11.entities.Material;
import br.futurodev.joinville.m1s11.mappers.MaterialMapper;
import br.futurodev.joinville.m1s11.repositories.MaterialRepository;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MaterialServiceImpl implements MaterialService {

    private final MaterialMapper mapper = Mappers.getMapper(MaterialMapper.class);

    private final MaterialRepository repository;

    public List<MaterialResponseDto> findAll() {
        List<Material> materials = repository.findAll();
        return materials.stream().map(mapper::toDto).toList();
    }

    @Override
    public MaterialResponseDto findById(Long id) {
        return mapper.toDto(findEntityById(id));
    }

    @Override
    public MaterialResponseDto create(MaterialRequestDto dto ) {
        Material material = new Material();
        mapper.toEntity(dto, material);

        material = repository.save(material);
        return mapper.toDto(material);
    }

    @Override
    public MaterialResponseDto update(Long id, MaterialRequestDto dto) {
        Material material = findEntityById(id);
        mapper.toEntity(dto, material);

        material = repository.save(material);
        return mapper.toDto(material);
    }

    @Override
    public void delete(Long id) {
        Material material = findEntityById(id);
        repository.delete(material);
    }

    private Material findEntityById(Long id) {
        return repository.findById(id).orElse(null);
    }

}
