package com.paula;

public class Tecnico extends HandlerSoporteTecnico {
    private final Dificultad maxDificultad;

    public Tecnico(Dificultad maxDificultad) {
        this.maxDificultad = maxDificultad;
    }

    @Override
    protected boolean puedeResolver(Ticket t) {
        return t.getDificultad().ordinal() <= maxDificultad.ordinal();
    }

    @Override
    protected void resolver(Ticket t) {
        System.out.println("Técnico " + this.maxDificultad + 
            "resolvió el problema.");
    }
}

