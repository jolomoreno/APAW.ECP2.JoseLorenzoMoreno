package api.dtos;

import api.entities.Competicion;

public class CompeticionIdNombreDto {

    private String id;

    private String nombre;

    public CompeticionIdNombreDto(Competicion competicion){
        this.id = competicion.getId();
        this.nombre = competicion.getNombre();
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
        return "CompeticionIdNombreDto{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
