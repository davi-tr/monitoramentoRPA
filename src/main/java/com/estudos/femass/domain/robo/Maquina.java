package com.estudos.femass.domain.robo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "maquina")
@Entity(name = "Maquina")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Maquina {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "NomeMaquina")
    private String nome;

    public Maquina(String st){
        this.nome = st;
    }
}
