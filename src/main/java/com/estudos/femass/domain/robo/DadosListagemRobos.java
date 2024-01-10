package com.estudos.femass.domain.robo;

import java.time.LocalDateTime;

public record DadosListagemRobos(Long id, String nome,String Maquina,String area, boolean status, LocalDateTime hora ) {

    public DadosListagemRobos(Robo robo){
        this(robo.getId(), robo.getNome(), robo.getMaquina(), robo.getArea(), robo.getStatus(), robo.getHora());
    }
}
