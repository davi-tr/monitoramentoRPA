package com.estudos.femass.domain.robo;

import com.estudos.femass.domain.maquina.Maquina;
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

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @Column(name = "Maquina")
    private List<Maquina> maquinas = new ArrayList<>();


    @Column(name = "Area")
    private String area;

    public Robo(DadosCadastroRobo dados){
        this.status = true;
        this.nome = dados.nome();
        this.area = dados.area();
        this.hora = LocalDateTime.now();
    }

    public void loadMaquians (Maquina maquina){
        maquinas.add(maquina);

    }
    public void atualizarHora(Robo robo){
        this.hora = LocalDateTime.now();
    }

    public void atualizaRobo(DadosAtualizarRobo dados){

        if (dados.nome() !=null){
            this.nome = dados.nome();
        }
        if (dados.maquina() !=null){
            maquinas.add(new Maquina(dados.maquina()));
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
