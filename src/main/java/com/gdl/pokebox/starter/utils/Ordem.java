package com.gdl.pokebox.starter.utils;

import com.gdl.pokebox.starter.model.Pokemon;

public class Ordem implements Ordenavel<Pokemon> {

    @Override
    public boolean compare(Pokemon p1, Pokemon p2) {
        return p1.getName().length() > p2.getName().length();
    }
}