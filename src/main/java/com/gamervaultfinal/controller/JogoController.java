package com.gamervaultfinal.controller;

import com.gamervaultfinal.model.Jogo;
import com.gamervaultfinal.repository.JogoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jogos")
@CrossOrigin(origins = "*")
public class JogoController {

    private final JogoRepository jogoRepository;

    public JogoController(JogoRepository jogoRepository) {
        this.jogoRepository = jogoRepository;
    }

    @GetMapping
    public List<Jogo> listarTodos() {
        return jogoRepository.findAll();
    }

    @PostMapping
    public Jogo salvar(@RequestBody Jogo jogo) {
        return jogoRepository.save(jogo);
    }

    @GetMapping("/pesquisar")
    public List<Jogo> pesquisar(@RequestParam String nome) {
        return jogoRepository.findByNomeContainingIgnoreCase(nome);
    }
}