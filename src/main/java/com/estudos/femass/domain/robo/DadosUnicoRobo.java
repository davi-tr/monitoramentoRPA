package com.estudos.femass.domain.robo;

import java.time.LocalDateTime;
import java.util.List;

public record DadosUnicoRobo(Long id, String nome, List<Maquina> maquina, String area, LocalDateTime hora) {
    public DadosUnicoRobo(Robo robo){
        this(robo.getId(), robo.getNome(), robo.getMaquinas(), robo.getArea(), robo.getHora());
    }
}
