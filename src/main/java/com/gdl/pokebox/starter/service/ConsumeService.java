package com.gdl.pokebox.starter.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.gdl.pokebox.starter.model.Pokemon;
import com.gdl.pokebox.starter.model.ResultPokemon;
import com.gdl.pokebox.starter.utils.Ordem;
import com.gdl.pokebox.starter.utils.OrdemAlfabetica;
import com.gdl.pokebox.starter.utils.Ordenavel;
import com.gdl.pokebox.starter.utils.Sorte;

@Service
public class ConsumeService {
    RestTemplate restTemplate = new RestTemplate();

    public ResponseEntity<ResultPokemon> obterNomePokemon() {
        String url = "https://pokeapi.co/api/v2/pokemon?limit=3000";

        ResponseEntity<ResultPokemon> response;

        try {
            response = new RestTemplate().getForEntity(url, ResultPokemon.class);
        } catch (RestClientException e) {
            throw new RestClientException(e.getMessage());
        }

        return response;
    }

    private boolean filtroPokemon(Pokemon pokemon, String query) {
        if (pokemon.getName().startsWith(query)) {
            String highlight = String.format("<pre>%s</pre>%s", query, pokemon.getName().substring(query.length()));
            pokemon.setHighlight(highlight);
            /*
             * Realiza a modificaçao quanto ao uso do <pre> no endpoint retornoPokemon
             */

            return true;
        } else {
            return false;
        }
    }

    public List<Pokemon> getFiltroPokemons(String query, String length) {
        /*
         * Essa linha cria um objeto order que implementa a Ordenavel(pacote Utils) com
         * base na condição
         */
        Ordenavel<Pokemon> order = "alphabetical".equals(length) ? new OrdemAlfabetica() : new Ordem();

        List<Pokemon> pokemonsList = obterNomePokemon()
                .getBody()
                .getResults()
                .stream()
                .filter(pokemon -> filtroPokemon(pokemon, query))
                .collect(Collectors.toList());

        Sorte.orderPokemons(pokemonsList, order);
        /*
         * A classe Sorte terá 4 métodos, sua funcionalidade é fazer diferentes
         * ordenações quanto aos parâmetros passados.
         * MÉTODO VOID => O método Sorte é propício a novos tipos de funcionalidades,
         * melhorias a API, aqui não há uma função ao nosso desafios.
         * 
         */

        return pokemonsList;
    }

    /* http://localhost:8080/OBTER/ */
    public Pokemon todosPokemons() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://pokeapi.co/api/v2/pokemon?limit=3000";
        ResponseEntity<Pokemon> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                /*
                 * O ParameterizedTypeReference serve para "filtrar" a resposta da API,
                 * tornando-a menos genérica
                 */
                new ParameterizedTypeReference<Pokemon>() {
                });
        return response.getBody();
    }
}
