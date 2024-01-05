package com.estudos.femass.domain.robo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizarRobo(
        @NotNull
        Long id,
        String nome,
        String maquina,
        String area
) {
}
