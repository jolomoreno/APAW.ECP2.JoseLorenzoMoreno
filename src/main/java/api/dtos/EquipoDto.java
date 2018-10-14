package api.dtos;

import api.entities.Categoria;

public class EquipoDto {

    private String nombre;

    private Categoria categoria;

    private String competicionId;

    public EquipoDto(String nombre, Categoria categoria, String competicionId){
        this.nombre = nombre;
        this.categoria = categoria;
        this.competicionId = competicionId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String getCompeticionId() {
        return competicionId;
    }

    public void setCompeticionId(String competicionId) {
        this.competicionId = competicionId;
    }

    @Override
    public String toString() {
        return "Equipo{" +
                "nombre='" + nombre + '\'' +
                ", categoria='" + categoria + '\'' +
                ", competicionId='" + competicionId + '\'' +
                '}';
    }
}
