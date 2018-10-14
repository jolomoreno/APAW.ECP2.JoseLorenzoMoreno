package api;

import api.apiControllers.CompeticionApiController;
import api.apiControllers.EquipoApiController;
import api.dtos.CompeticionDto;
import api.dtos.EquipoDto;
import api.entities.Categoria;
import http.Client;
import http.HttpException;
import http.HttpRequest;
import http.HttpStatus;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class EquipoIT {

    @Test
    void testCreateEquipo() {
        this.createEquipo("Equipo Movistar");
    }

    private String createEquipo(String nombre) {
        String competicionId = this.createCompeticion();
        HttpRequest request = HttpRequest.builder(EquipoApiController.EQUIPOS)
                .body(new EquipoDto(nombre, Categoria.ELITE, competicionId)).post();
        return (String) new Client().submit(request).getBody();
    }

    private String createCompeticion() {
        HttpRequest request = HttpRequest.builder(CompeticionApiController.COMPETICIONES).body(new CompeticionDto("La Vuelta")).post();
        return (String) new Client().submit(request).getBody();
    }


    @Test
    void testCreateEquipoWithoutEquipoDtoNombre() {
        String competicionId = this.createCompeticion();
        HttpRequest request = HttpRequest.builder(EquipoApiController.EQUIPOS)
                .body(new EquipoDto(null, Categoria.ELITE, competicionId )).post();
        HttpException exception = assertThrows(HttpException.class, () -> new Client().submit(request));
        assertEquals(HttpStatus.BAD_REQUEST, exception.getHttpStatus());
    }

    @Test
    void testCreateEquipoCompeticionIdNotFound() {
        HttpRequest request = HttpRequest.builder(EquipoApiController.EQUIPOS)
                .body(new EquipoDto("Equipo Sky", Categoria.SENIOR, "9999")).post();
        HttpException exception = assertThrows(HttpException.class, () -> new Client().submit(request));
        assertEquals(HttpStatus.NOT_FOUND, exception.getHttpStatus());
    }

    @Test
    void testCreateEquipoWithoutCategoriaCompeticion() {
        HttpRequest request = HttpRequest.builder(EquipoApiController.EQUIPOS)
                .body(new EquipoDto("Equipo BMC", null, null)).post();
        new Client().submit(request);
    }
}
