package com.gdl.pokebox.starter.exceptions;

public class ConsumeError extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public ConsumeError(String ex) {
        super(ex);
    }

    public ConsumeError(String mensagem, Throwable throwable) {
        super(mensagem, throwable);
    }
}
