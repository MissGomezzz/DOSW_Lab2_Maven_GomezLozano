package com.paula;
import java.util.Map;
import java.util.HashMap;;

public class TasasDeCambio implements EstrategiaTasaCambio {
    private final Map<String, Double> tasas = new HashMap<>();

    public TasasDeCambio() {
        tasas.put("USD->COP", 4000.0);
        tasas.put("COP->USD", 1.0 / 4000.0);

        tasas.put("EUR->USD", 1.10);
        tasas.put("USD->EUR", 1.0 / 1.10);

        tasas.put("USD->JPY", 150.0);
        tasas.put("JPY->USD", 1.0 / 150.0);

        tasas.put("EUR->JPY", 1.10 * 150.0);
        tasas.put("JPY->EUR", 1.0 / (1.10 * 150.0));

        tasas.put("EUR->COP", 1.10 * 4000.0);
        tasas.put("COP->EUR", 1.0 / (1.10 * 4000.0));

        tasas.put("JPY->COP", (1.0 / 150.0) * 4000.0); 
        tasas.put("COP->JPY", 1.0 / ((1.0 / 150.0) * 4000.0));
    }
    
    @Override
    public double obtenerTasaCambio(Moneda origen, Moneda destino) {
        if (origen == destino) return 1.0;

        String clave = origen + "->" + destino;
        Double tasa = tasas.get(clave);

        if (tasa == null  ) {
            throw new IllegalArgumentException("No se encontró la tasa de cambio para " + clave);
        }
        return tasa;
    }
}
