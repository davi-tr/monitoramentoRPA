package com.estudos.femass.domain.robo;

import java.time.LocalDateTime;
import java.util.List;

public record DadosListagemRobos(Long id, String nome, List<com.estudos.femass.domain.maquina.Maquina> Maquina, String area, boolean status, LocalDateTime hora ) {

    public DadosListagemRobos(Robo robo){
        this(robo.getId(), robo.getNome(), robo.getMaquinas(), robo.getArea(), robo.getStatus(), robo.getHora());
    }
}
