package com.estudos.femass.repository.robo;

import com.estudos.femass.domain.robo.Robo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RoboRepository extends JpaRepository<Robo, Long> {
    @Query("SELECT r FROM Robo r JOIN r.maquinas m WHERE r.nome = :nome AND m.nome = :nomeMaquina")
    Robo findByNomeAndNomeMaquina(String nome, String nomeMaquina);

    @Query("SELECT r FROM Robo r WHERE r.nome = :nome")
    Robo getReferenceByNome(String nome);
}
