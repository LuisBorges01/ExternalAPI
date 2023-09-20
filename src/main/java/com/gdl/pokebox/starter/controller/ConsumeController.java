package com.gdl.pokebox.starter.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gdl.pokebox.starter.exceptions.ConsumeError;
import com.gdl.pokebox.starter.model.Pokemon;
import com.gdl.pokebox.starter.service.ConsumeService;

@RequestMapping("/OBTER")
@RestController
public class ConsumeController {

    private ConsumeService pokemonService = new ConsumeService();

    @GetMapping()
    @Cacheable("cachetodos")
    public Pokemon todosPokemons() {
        return pokemonService.todosPokemons();
    }

    /*
     * O controller enviará a classe service que fará todo o processo de ordenação
     * quanto as classificações
     */
    @GetMapping("/pokemon")
    @Cacheable("cacheordenavel")
    public ResponseEntity<List<Pokemon>> retornoPokemon(@RequestParam(name = "q", required = false) String query,
            @RequestParam(name = "length", required = false) String length) {
        if (query != null || length != null) {
            List<Pokemon> pokemons = pokemonService.getFiltroPokemons(query, length);
            return ResponseEntity.ok().body(pokemons);
        } else {
            Pokemon pokemon = pokemonService.todosPokemons();
            return ResponseEntity.ok().body(Collections.singletonList(pokemon));
        }
    }

    /*
     * O método @ExceptionHandler está sendo usado CASO a POKEAPI venha a falhar
     * O método busca o erro ConsumeError de uma forma global e trata-o.
     */
    @ExceptionHandler(ConsumeError.class)
    public ResponseEntity<String> capturar(ConsumeError e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}