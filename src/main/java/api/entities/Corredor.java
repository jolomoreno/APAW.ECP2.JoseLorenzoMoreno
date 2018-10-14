package api.entities;

public class Corredor {

    private String id;

    private String nombre;

    private int dorsal;

    public Corredor(String nombre) {
        this.nombre = nombre;
        this.dorsal = 0;
    }

    public Corredor(String nombre, int dorsal) {
        this.nombre = nombre;
        this.dorsal = dorsal;
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

    public int getDorsal() {
        return dorsal;
    }

    public void setDorsal(int dorsal) {
        this.dorsal =  dorsal;
    }

    @Override
    public String toString() {
        return "Corredor{" +
                ", id=" + id +
                ", nombre=" + nombre +
                ", dorsal=" + dorsal +
                '}';
    }
}
