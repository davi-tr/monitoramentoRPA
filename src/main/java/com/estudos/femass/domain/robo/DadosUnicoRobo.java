package com.estudos.femass.domain.robo;

import java.time.LocalDateTime;

public record DadosUnicoRobo(Long id, String nome, String maquina, String area, LocalDateTime hora) {
    public DadosUnicoRobo(Robo robo){
        this(robo.getId(), robo.getNome(), robo.getMaquina(), robo.getArea(), robo.getHora());
    }
}
