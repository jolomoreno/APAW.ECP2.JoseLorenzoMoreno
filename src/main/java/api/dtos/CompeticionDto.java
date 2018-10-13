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

    public LocalDateTime getFecha() {
        return fecha;
    }

    @Override
    public String toString() {
        return "CompeticionDto{" +
                "nombre='" + nombre + '\'' +
                ", fecha='" + fecha + '\'' +
                '}';
    }
}
