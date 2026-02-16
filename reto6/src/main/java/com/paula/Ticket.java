package com.paula;

public class Ticket {
    private final int id;
    private final String descripcion;
    private final Dificultad dificultad;

    public Ticket(int id, String descripcion, Dificultad dificultad, Prioridad prioridad) {
        if (descripcion == null || descripcion.isBlank()) {
            throw new IllegalArgumentException("La descripción no puede ser vacía");
        }
        if (dificultad == null) {
            throw new IllegalArgumentException("La dificultad no puede ser nula");
        }
        this.id = id;
        this.descripcion = descripcion;
        this.dificultad = dificultad;
    }

    public int getId() { return id; }
    public String getDescripcion() { return descripcion; }
    public Dificultad getDificultad() { return dificultad; }
}
