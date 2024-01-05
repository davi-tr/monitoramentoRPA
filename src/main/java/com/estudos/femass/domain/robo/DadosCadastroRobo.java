package com.estudos.femass.domain.robo;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastroRobo(
        @NotBlank
        String nome,
        @NotBlank
        String maquina,
        @NotBlank
        String area
) {
}
