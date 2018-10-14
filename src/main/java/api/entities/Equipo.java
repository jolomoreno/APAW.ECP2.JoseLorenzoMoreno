package api.entities;

import java.util.ArrayList;
import java.util.List;

public class Equipo {
    private String id;

    private String nombre;

    private int numCorredores;

    private Categoria categoria;

    private Competicion competicion;

    private List<Corredor> corredores;

    public Equipo(String nombre){
        this.nombre = nombre;
        this.corredores = new ArrayList<>();
    }

    public static Builder builder(String nombre) {
        return new Builder(nombre);
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

    public int getNumCorredores() {
        return numCorredores;
    }

    public void setNumCorredores(int numCorredores) {
        this.numCorredores = numCorredores;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Competicion getCompeticion() {
        return competicion;
    }

    public void setCompeticion(Competicion competicion) {
        this.competicion = competicion;
    }

    public List<Corredor> getCorredores() {
        return corredores;
    }

    public void setCorredores(List<Corredor> corredores) {
        this.corredores = corredores;
    }

    @Override
    public String toString() {
        return "Equipo{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", numCorredores='" + numCorredores + '\'' +
                ", categoria='" + categoria + '\'' +
                ", competicion='" + competicion + '\'' +
                ", corredores='" + corredores + '\'' +
                '}';
    }

    public static class Builder {
        private Equipo equipo;

        private Builder(String nombre) {
            this.equipo = new Equipo(nombre);
        }

        public Builder id(String id) {
            this.equipo.id = id;
            return this;
        }

        public Builder numCorredores(int numCorredores) {
            this.equipo.numCorredores = numCorredores;
            return this;
        }

        public Builder categoria(Categoria categoria) {
            this.equipo.categoria = categoria;
            return this;
        }

        public Builder competicion(Competicion competicion) {
            this.equipo.competicion = competicion;
            return this;
        }


        public Builder corredores(Corredor corredor) {
            this.equipo.corredores.add(corredor);
            return this;
        }

        public Equipo build() {
            return this.equipo;
        }
    }
}
