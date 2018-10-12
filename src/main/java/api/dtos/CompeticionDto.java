package api.dtos;

import java.time.LocalDateTime;

public class CompeticionDto {

    private String nombre;

    private LocalDateTime fecha;

    public CompeticionDto(String nombre, LocalDateTime fecha){
        this.nombre = nombre;
        this.fecha = fecha;
    }

    public CompeticionDto(String nombre){
        this.nombre = nombre;
        this.fecha = LocalDateTime.now();
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
        return "CompeticionDto{" +
                "nombre='" + nombre + '\'' +
                ", fecha='" + fecha + '\'' +
                '}';
    }
}
