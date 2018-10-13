package api;

import api.apiControllers.CompeticionApiController;
import api.dtos.CompeticionDto;
import api.dtos.CompeticionIdNombreDto;
import http.Client;
import http.HttpException;
import http.HttpRequest;
import http.HttpStatus;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CompeticionIT {

    @Test
    void testCompeticionInvalidRequest() {
        HttpRequest request = HttpRequest.builder(CompeticionApiController.COMPETICIONES).path("/invalid").body(null).post();
        HttpException exception = assertThrows(HttpException.class, () -> new Client().submit(request));
        assertEquals(HttpStatus.BAD_REQUEST, exception.getHttpStatus());
    }

    @Test
    void testCreateCompeticionWithoutCompeticionDto() {
        HttpRequest request = HttpRequest.builder(CompeticionApiController.COMPETICIONES).body(null).post();
        HttpException exception = assertThrows(HttpException.class, () -> new Client().submit(request));
        assertEquals(HttpStatus.BAD_REQUEST, exception.getHttpStatus());
    }

    @Test
    void testCreateCompeticionWithoutCompeticionDtoNombre() {
        HttpRequest request = HttpRequest.builder(CompeticionApiController.COMPETICIONES).body(new CompeticionDto(null)).post();
        HttpException exception = assertThrows(HttpException.class, () -> new Client().submit(request));
        assertEquals(HttpStatus.BAD_REQUEST, exception.getHttpStatus());
    }

    @Test
    void testCreateCompeticion() {
        this.createCompeticion();
    }

    private String createCompeticion() {
        HttpRequest request = HttpRequest.builder(CompeticionApiController.COMPETICIONES).body(new CompeticionDto("La Vuelta")).post();
        return (String) new Client().submit(request).getBody();
    }

    @Test
    void testReadAll() {
        for (int i = 0; i < 5; i++) {
            this.createCompeticion();
        }
        HttpRequest request = HttpRequest.builder(CompeticionApiController.COMPETICIONES).get();
        List<CompeticionIdNombreDto> competiciones = (List<CompeticionIdNombreDto>) new Client().submit(request).getBody();
        assertTrue(competiciones.size() >= 5);
    }

}
