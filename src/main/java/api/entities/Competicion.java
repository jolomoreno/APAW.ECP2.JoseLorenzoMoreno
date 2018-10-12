package api.entities;

import java.time.LocalDateTime;

public class Competicion {
    private String id;

    private String nombre;

    private LocalDateTime fecha;

    public Competicion(String nombre, LocalDateTime fecha){
        this.nombre = nombre;
        this.fecha = fecha;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Competicion{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", fecha='" + fecha + '\'' +
                '}';
    }
}
