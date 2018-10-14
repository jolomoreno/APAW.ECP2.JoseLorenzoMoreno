package api.dtos;

import api.entities.Competicion;

public class CompeticionIdNombreDto {

    private String id;

    private String nombre;

    public CompeticionIdNombreDto(Competicion competicion){
        this.id = competicion.getId();
        this.nombre = competicion.getNombre();
    }

    public String getIdCompeticion() {
        return id;
    }

    public void setIdCompeticion(String id) {
        this.id = id;
    }

    public String getNombreCompeticion() {
        return nombre;
    }

    public void setNombreCompeticion(String nombre) {
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
