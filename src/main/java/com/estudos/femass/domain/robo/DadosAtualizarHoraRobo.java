package com.estudos.femass.domain.robo;

import jakarta.validation.constraints.NotBlank;

public record DadosAtualizarHoraRobo(

        @NotBlank
        String nome,
        @NotBlank
        String maquina
) {
}
