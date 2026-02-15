package com.paula;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Reto6 {

    // Para guardar el resultado de cada ticket (si fue resuelto o no)
    private static class ResultadoTicket {
        private final Ticket ticket;
        private final boolean resuelto;

        public ResultadoTicket(Ticket ticket, boolean resuelto) {
            this.ticket = ticket;
            this.resuelto = resuelto;
        }

        public Ticket getTicket() { return ticket; }
        public boolean isResuelto() { return resuelto; }
    }

    public static void ejecutar() {

        // 1) Crear técnicos (cadena)
        Tecnico basico = new Tecnico(Dificultad.BASICA);
        Tecnico intermedio = new Tecnico(Dificultad.INTERMEDIA);
        Tecnico avanzado = new Tecnico(Dificultad.AVANZADA);

        basico.setSiguiente(intermedio).setSiguiente(avanzado);

        // 2) Leer tickets
        Scanner sc = new Scanner(System.in);
        System.out.print("Número de tickets: ");
        int n = Integer.parseInt(sc.nextLine().trim());

        List<Ticket> tickets = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            System.out.println("\n--- Ticket " + i + " ---");

            System.out.print("Descripción: ");
            String descripcion = sc.nextLine();

            System.out.print("Nivel: (BASICA, INTERMEDIA, AVANZADA): ");
            Dificultad dificultad = leerDificultad(sc);

            System.out.print("Prioridad: ");
            Prioridad prioridad = leerPrioridad(sc);

            tickets.add(new Ticket(i, descripcion, dificultad, prioridad));
        }

        // 3) Procesar tickets y guardar resultados
        System.out.println("\n--- Procesando tickets ---");

        List<ResultadoTicket> resultados = tickets.stream()
                .map(t -> new ResultadoTicket(t, basico.evaluarTicket(t)))
                .toList();

        // 4) Estadísticas con Streams

        // 4.1 Conteo de tickets por nivel
        Map<Dificultad, Long> ticketsPorNivel = tickets.stream()
                .collect(Collectors.groupingBy(
                        Ticket::getDificultad,
                        Collectors.counting()
                ));

        // 4.2 Conteo resueltos y pendientes
        long resueltos = resultados.stream()
                .filter(ResultadoTicket::isResuelto)
                .count();

        long pendientes = resultados.size() - resueltos;

        // 4.3 Pendientes por nivel
        Map<Dificultad, Long> pendientesPorNivel = resultados.stream()
                .filter(r -> !r.isResuelto())
                .collect(Collectors.groupingBy(
                        r -> r.getTicket().getDificultad(),
                        Collectors.counting()
                ));

        // 5) Imprimir resumen
        System.out.println("\n========== RESUMEN ==========");

        System.out.println("\nTickets por nivel:");
        imprimirConteosPorDificultad(ticketsPorNivel);

        System.out.println("\nEstado general:");
        System.out.println("Resueltos: " + resueltos);
        System.out.println("Pendientes: " + pendientes);

        System.out.println("\nPendientes por nivel:");
        imprimirConteosPorDificultad(pendientesPorNivel);

        System.out.println("=============================\n");
    }

    private static Dificultad leerDificultad(Scanner sc) {
        while (true) {
            String entrada = sc.nextLine().trim().toUpperCase();
            try {
                return Dificultad.valueOf(entrada);
            } catch (IllegalArgumentException e) {
                System.out.print("Valor inválido. Use BASICA, INTERMEDIA o AVANZADA: ");
            }
        }
    }

    private static Prioridad leerPrioridad(Scanner sc) {
        while (true) {
            String entrada = sc.nextLine().trim().toUpperCase();
            try {
                return Prioridad.valueOf(entrada);
            } catch (IllegalArgumentException e) {
                System.out.print("Valor inválido. Use ALTA, MEDIA o BAJA: ");
            }
        }
    }

    private static void imprimirConteosPorDificultad(Map<Dificultad, Long> mapa) {
        // Imprime en orden BASICA -> INTERMEDIA -> AVANZADA
        for (Dificultad d : Dificultad.values()) {
            long valor = mapa.getOrDefault(d, 0L);
            System.out.println(d + ": " + valor);
        }
    }
}
