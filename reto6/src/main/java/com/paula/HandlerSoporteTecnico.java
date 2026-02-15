package com.paula;

public abstract class HandlerSoporteTecnico {
    private HandlerSoporteTecnico siguiente;

    public HandlerSoporteTecnico setSiguiente(HandlerSoporteTecnico s) {
        this.siguiente = s;
        return s;
    }

    public final boolean evaluarTicket(Ticket t) {
        if (puedeResolver(t)) {
            resolver(t);
            return true;
        }
        if (siguiente != null) {
            siguiente.evaluarTicket(t);
            return siguiente.evaluarTicket(t);
        }
        System.out.println("Ningún técnico disponible. Ticket pendiente de escalamiento.");
        return false;
    }

    protected abstract boolean puedeResolver(Ticket t);
    protected abstract void resolver(Ticket t);
}
