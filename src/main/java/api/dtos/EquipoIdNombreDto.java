package api.dtos;

import api.entities.Equipo;

public class EquipoIdNombreDto {

    private String id;

    private String nombre;

    public EquipoIdNombreDto(Equipo equipo){
        this.id = equipo.getId();
        this.nombre = equipo.getNombre();
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


    @Override
    public String toString() {
        return "EquipoIdNombreDto{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
