package com.estudos.femass.controller;

import com.estudos.femass.domain.robo.*;
import com.estudos.femass.repository.robo.RoboRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/RPA")
public class RoboController {

    @Autowired
    private RoboRepository repository;

    @PostMapping
    public ResponseEntity cadastro(@RequestBody @Valid DadosCadastroRobo dados, UriComponentsBuilder uriBuilder){
        var robo = new Robo(dados);
        var roboBusca = repository.findAllByNomeAndStatusTrue(dados.nome());
        if(roboBusca !=null){
            return ResponseEntity.badRequest().body(new MensagemErro("Robô já existe"));
        }
        repository.save(robo);

        var uri = uriBuilder.path("RPA/id={id}").buildAndExpand(robo.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosUnicoRobo(robo));
    }

    @PutMapping()
    public ResponseEntity atualizaHora(@RequestBody @Valid DadosAtualizarHoraRobo dados){
        var robo = repository.findAllByNomeAndStatusTrue(dados.nome());
        robo.atualizarHora(robo);
        repository.save(robo);

        return ResponseEntity.ok(new DadosUnicoRobo(robo));
    }
    @PutMapping("/edit")
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizarRobo dados){
        var robo = repository.getReferenceById(dados.id());
        robo.atualizaRobo(dados);
        repository.save(robo);

        return ResponseEntity.ok(new DadosUnicoRobo(robo));
    }
    private record MensagemErro(String mensagem){

    }

}
