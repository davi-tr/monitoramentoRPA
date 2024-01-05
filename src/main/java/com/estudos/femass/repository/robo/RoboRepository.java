package com.estudos.femass.repository.robo;

import com.estudos.femass.domain.robo.Robo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoboRepository extends JpaRepository<Robo, Long> {
    Robo findAllByNomeAndStatusTrue(String nome);
}
