package com.paula;
import java.util.List;

public class Transaccion {
    private Moneda monedaOrigen;
    private List<Moneda> monedasDestino;
    private double monto;

    public Transaccion(Moneda monedaOrigen, List<Moneda> monedasDestino, double monto) {
        if (monto <= 0) {
            throw new IllegalArgumentException("El monto debe ser positivo.");
        }
        this.monedaOrigen = monedaOrigen;
        this.monedasDestino = monedasDestino;
        this.monto = monto;
    }

    public Moneda getMonedaOrigen() {
        return this.monedaOrigen;
    }
    public List<Moneda> getMonedasDestino() {
        return this.monedasDestino;
    }
    public double getMonto() {
        return this.monto;
    }
}
