package com.paula;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Reto6Test {

    @Test
    void ticketNoPermiteDescripcionVacia() {
        assertThrows(IllegalArgumentException.class, () ->
                new Ticket(1, "   ", Dificultad.BASICA, Prioridad.BAJA)
        );
    }

    @Test
    void tecnicoBasicoResuelveTicketBasico() {
        Tecnico basico = new Tecnico(Dificultad.BASICA);
        Ticket t = new Ticket(1, "No enciende", Dificultad.BASICA, Prioridad.MEDIA);

        boolean resuelto = basico.evaluarTicket(t);

        assertTrue(resuelto, "Un técnico básico debe resolver un ticket de dificultad básica");
    }

    @Test
    void cadenaResuelveTicketAvanzadoConTecnicoAvanzado() {
        Tecnico basico = new Tecnico(Dificultad.BASICA);
        Tecnico intermedio = new Tecnico(Dificultad.INTERMEDIA);
        Tecnico avanzado = new Tecnico(Dificultad.AVANZADA);

        basico.setSiguiente(intermedio).setSiguiente(avanzado);

        Ticket t = new Ticket(99, "Problema complejo", Dificultad.AVANZADA, Prioridad.ALTA);

        boolean resuelto = basico.evaluarTicket(t);

        assertTrue(resuelto, "La cadena debe escalar hasta el técnico avanzado y resolver el ticket");
    }
}
