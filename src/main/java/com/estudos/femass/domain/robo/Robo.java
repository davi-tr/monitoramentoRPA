package com.estudos.femass.domain.robo;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;


@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "robo")
@Entity(name = "Robo")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Robo {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "Status")
    private boolean status;

    @Column(name = "NomeRobo")
    private String nome;

    @Column(name = "HoraAtualiza")
    private LocalDateTime hora;

    @Column(name = "Maquina")
    private String maquinas;


    @Column(name = "Area")
    private String area;

    public Robo(DadosCadastroRobo dados){
        this.status = true;
        this.nome = dados.nome();
        this.area = dados.area();
        this.hora = LocalDateTime.now();
        this.maquinas = dados.maquina();
    }

    public void atualizarHora(Robo robo){
        this.hora = LocalDateTime.now();
    }

    public void atualizaRobo(DadosAtualizarRobo dados){

        if (dados.nome() !=null){
            this.nome = dados.nome();
        }
        if (dados.maquina() !=null){
            this.maquinas = dados.maquina();
        }
        if (dados.area() !=null){
            this.area = dados.area();
        }
    }
    public boolean getStatus(){
        return status;
    }

    public void checkStatus(Robo robo){
        long diferenca = Math.abs(ChronoUnit.MINUTES.between(robo.getHora(), LocalDateTime.now()));
        if(diferenca > 60){
            this.status = false;
            System.out.println(robo.nome+": "+diferenca);
        } else {
            this.status = true;
        }
    }

}
