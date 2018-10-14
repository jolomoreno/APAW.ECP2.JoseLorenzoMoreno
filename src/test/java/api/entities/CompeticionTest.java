package api.entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CompeticionTest {

    private Competicion competicion;

    @BeforeEach
    void before(){
        competicion = new Competicion("Tour de Francia", LocalDateTime.now());
    }

    @Test
    void testCompeticion(){
        String now = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        assertEquals( "Tour de Francia", competicion.getNombre());
        String fechaFormat = competicion.getFecha().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        assertEquals( now, fechaFormat);
    }

    @Test
    void testSetNombre(){
        competicion.setNombre("La Vuelta");
        assertEquals("La Vuelta", competicion.getNombre());
    }

    @Test
    void testSetFecha(){
        String now = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        competicion.setFecha(LocalDateTime.now());
        String fechaFormat = competicion.getFecha().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        assertEquals(now, fechaFormat);
    }

    @Test
    void testID(){
        competicion.setId("1");
        assertEquals("1", competicion.getId());
    }

}
