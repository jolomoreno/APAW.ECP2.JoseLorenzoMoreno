package api.entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EquipoTest {

    private Equipo equipo;

    private Competicion competicion;

    private Categoria categoria;

    private List<Corredor> corredores;

    private Corredor corredor1;

    private Corredor corredor2;

    List<Corredor> corredoresEquipo;

    @BeforeEach
    void before(){
        competicion = new Competicion("Tour de Francia", LocalDateTime.now());
        equipo = new Equipo("Equipo Movistar");
        this.corredores = new ArrayList<>();
        corredor1 = new Corredor("Alberto Contador", 1);
        corredor2 = new Corredor("Chris Froome", 2);
        this.corredores.add(corredor1);
        this.corredores.add(corredor2);
        equipo.setCorredores(corredores);
        corredoresEquipo = equipo.getCorredores();
    }

    @Test
    void testEquipo(){
        assertEquals( "Equipo Movistar", equipo.getNombre());
    }

    @Test
    void testnumCorredoresEquipo(){
        equipo.setNumCorredores(8);
        assertEquals( 8, equipo.getNumCorredores());
    }

    @Test
    void testCategoriaEquipo(){
        equipo.setCategoria(categoria.JUNIOR);
        assertEquals( "JUNIOR", equipo.getCategoria().toString());
    }

    @Test
    void testCompeticionEquipo(){
        equipo.setCompeticion(competicion);
        assertEquals( "Tour de Francia", equipo.getCompeticion().getNombre());
    }

    @Test
    void testCorredoresEquipo(){
        assertEquals( 1, corredor1.getDorsal());
        assertEquals( 2, corredor2.getDorsal());
        assertEquals( 2, corredoresEquipo.size());
    }

}
