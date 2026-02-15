package com.paula;
import java.util.Map;
import java.util.LinkedHashMap;

public class CasaDeCambio {

    private final EstrategiaTasaCambio estrategia;
    public CasaDeCambio(EstrategiaTasaCambio estrategia) {
        this.estrategia = estrategia;
    }

    public Map<Moneda, Double> convertir(Transaccion t) {
        Map<Moneda, Double> resultados = new LinkedHashMap<>();
        for (Moneda d : t.getMonedasDestino()) {
            double tasa = estrategia.obtenerTasaCambio(t.getMonedaOrigen(), d);
            resultados.put(d, t.getMonto() * tasa);
        }
        return resultados;
    }
    
}
