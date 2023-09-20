package com.gdl.pokebox.starter.model;

import java.util.List;

/*Saudades Loombok =D*/
public class Pokemon {
    private String name;
    private String highlight;
    private List<PokemonEntry> results;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHighlight() {
        return highlight;
    }

    public void setHighlight(String highlight) {
        this.highlight = highlight;
    }

    public List<PokemonEntry> getResults() {
        return results;
    }

    public void setResults(List<PokemonEntry> results) {
        this.results = results;

    }

    /*
     * Classe estática que "ren"os resultados da
     * pesquisa geral somente para os NOMES
     * OBS: CLasse se fez necessária pela consulta do segundo endpoint
     */
    public static class PokemonEntry {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
