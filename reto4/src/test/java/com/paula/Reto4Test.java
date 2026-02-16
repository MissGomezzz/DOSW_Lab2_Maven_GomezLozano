package com.paula;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class Reto4Test {

    @Test
    void transaccionNoPermiteMontoCeroONegativo() {
        assertThrows(IllegalArgumentException.class, () ->
                new Transaccion(Moneda.USD, List.of(Moneda.COP), 0)
        );

        assertThrows(IllegalArgumentException.class, () ->
                new Transaccion(Moneda.USD, List.of(Moneda.COP), -500)
        );
    }

    @Test
    void casaDeCambioConvierteAVariasMonedasDestinoCorrectamente() {
        EstrategiaTasaCambio estrategia = new TasasDeCambio();
        CasaDeCambio casa = new CasaDeCambio(estrategia);

        // 10 USD a COP y EUR
        Transaccion t = new Transaccion(Moneda.USD, List.of(Moneda.COP, Moneda.EUR), 10.0);

        Map<Moneda, Double> resultados = casa.convertir(t);

        assertEquals(2, resultados.size());
        assertEquals(10.0 * 4000.0, resultados.get(Moneda.COP), 1e-9); // USD->COP = 4000
        assertEquals(10.0 * (1.0 / 1.10), resultados.get(Moneda.EUR), 1e-9); // USD->EUR = 1/1.10
    }
}
