package br.futurodev.joinville.m1s11.repositories;

import br.futurodev.joinville.m1s11.entities.Material;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaterialRepository extends JpaRepository<Material, Long> {
}
