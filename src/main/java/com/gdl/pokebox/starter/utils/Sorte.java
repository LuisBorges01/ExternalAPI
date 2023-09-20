package com.gdl.pokebox.starter.utils;

import java.util.Collections;
import java.util.List;

import com.gdl.pokebox.starter.model.Pokemon;

public class Sorte {

    private static Ordenavel<Pokemon> sorting;

    public static void orderPokemons(List<Pokemon> pokemons, Ordenavel<Pokemon> order) {
        sorting = order;

        sorte(pokemons, 0, pokemons.size() - 1);
    }

    public static void sorte(List<Pokemon> pokemons, int begin, int end) {
        if (begin < end) {
            int partitionIndex = partição(pokemons, begin, end);

            sorte(pokemons, begin, partitionIndex - 1);
            sorte(pokemons, partitionIndex + 1, end);
        }
    }

    private static int partição(List<Pokemon> pokemons, int begin, int end) {
        com.gdl.pokebox.starter.model.Pokemon pivot = pokemons.get(end);

        int beginIndex = begin;

        for (int currentIndex = beginIndex; currentIndex < end; currentIndex++) {
            if (sorting.compare(pivot, pokemons.get(currentIndex))) {
                Collections.swap(pokemons, beginIndex, currentIndex);
                // swapPokemons(pokemons, beginIndex, currentIndex);

                beginIndex++;
            }
        }

        Collections.swap(pokemons, beginIndex, end);
        // swapPokemons(pokemons, beginIndex, end);

        return beginIndex;
    }

    public static void swapPokemons(List<Pokemon> list, final int pos1, final int pos2) {
        final Pokemon temp = list.get(pos1);
        list.set(pos1, list.get(pos2));
        list.set(pos2, temp);
    }
}