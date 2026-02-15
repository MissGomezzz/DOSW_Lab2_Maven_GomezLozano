package com.paula;
import java.util.*;
import java.util.stream.Collectors;

public class Reto4 {

    public static void ejecutar() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese número de transacciones: ");
        int numeroTransacciones = Integer.parseInt(sc.nextLine().trim());

        List<Transaccion> transacciones = new ArrayList<>();

        for (int i = 0; i < numeroTransacciones; i++) {
            System.out.println("\n--- Transacción " + (i + 1) + " ---");

            System.out.print("Ingrese monto: ");
            double monto = Double.parseDouble(sc.nextLine().trim().replace(",", "."));

            System.out.print("Ingrese moneda de origen (USD, EUR, JPY, COP): ");
            Moneda origen = Moneda.valueOf(sc.nextLine().trim().toUpperCase());

            System.out.print("Ingrese monedas destino (separadas por coma, ej: USD,JPY): ");
            String entradaDestinos = sc.nextLine().trim().toUpperCase();

            List<Moneda> destinos = Arrays.stream(entradaDestinos.split(","))
                    .map(String::trim)
                    .filter(s -> !s.isEmpty())
                    .map(Moneda::valueOf)
                    .toList();

            transacciones.add(new Transaccion(origen, destinos, monto));
        }

        CasaDeCambio casa = new CasaDeCambio(new TasasDeCambio());

        for (int i = 0; i < transacciones.size(); i++) {
            Transaccion t = transacciones.get(i);

            System.out.println("\nTransacción " + (i + 1) + ": " + formatear(t.getMonto()) + " " + t.getMonedaOrigen());

            Map<Moneda, Double> conv = casa.convertir(t);
            conv.forEach((dest, montoConvertido) -> {
                System.out.println("  Convertido a " + dest + ": " + formatear(montoConvertido) + " " + dest);
            });
        }

        Map<Moneda, Double> totales = transacciones.stream()
                .flatMap(t -> casa.convertir(t).entrySet().stream()) // (destino, montoConvertido)
                .collect(Collectors.groupingBy(
                        Map.Entry::getKey,
                        Collectors.summingDouble(Map.Entry::getValue)
                ));

        System.out.println("\n--- Totales por moneda ---");
        totales.forEach((moneda, total) ->
                System.out.println(moneda + ": " + formatear(total) + " " + moneda)
        );
    }

    private static String formatear(double v) {
        return String.format(Locale.US, "%.2f", v);
    }
}
