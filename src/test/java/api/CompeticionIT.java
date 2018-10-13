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

    private String createCompeticion() {
        HttpRequest request = HttpRequest.builder(CompeticionApiController.COMPETICIONES).body(new CompeticionDto("La Vuelta")).post();
        return (String) new Client().submit(request).getBody();
    }

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

    @Test
    void testReadAll() {
        for (int i = 0; i < 5; i++) {
            this.createCompeticion();
        }
        HttpRequest request = HttpRequest.builder(CompeticionApiController.COMPETICIONES).get();
        List<CompeticionIdNombreDto> competiciones = (List<CompeticionIdNombreDto>) new Client().submit(request).getBody();
        assertTrue(competiciones.size() >= 5);
    }

    @Test
    void testUpdateCompeticion() {
        String id = this.createCompeticion();
        HttpRequest request = HttpRequest.builder(CompeticionApiController.COMPETICIONES).path(CompeticionApiController.ID)
                .expandPath(id).body(new CompeticionDto("Vuelta a Burgos")).put();
        new Client().submit(request);
    }

    @Test
    void testUpdateCompeticionWithoutCompeticionDto() {
        String id = this.createCompeticion();
        HttpRequest request = HttpRequest.builder(CompeticionApiController.COMPETICIONES).path(CompeticionApiController.ID)
                .expandPath(id).body(null).put();
        HttpException exception = assertThrows(HttpException.class, () -> new Client().submit(request));
        assertEquals(HttpStatus.BAD_REQUEST, exception.getHttpStatus());
    }

    @Test
    void testUpdateCompeticionBadRequestException() {
        HttpRequest request = HttpRequest.builder(CompeticionApiController.COMPETICIONES).path(CompeticionApiController.ID)
                .expandPath("incorrectPath").body(new CompeticionDto("Il Giro")).put();
        HttpException exception = assertThrows(HttpException.class, () -> new Client().submit(request));
        assertEquals(HttpStatus.NOT_FOUND, exception.getHttpStatus());
    }

    @Test
    void testDelete() {
        String id = this.createCompeticion();
        HttpRequest request1 = HttpRequest.builder(CompeticionApiController.COMPETICIONES).get();
        int count = ((List<CompeticionIdNombreDto>) new Client().submit(request1).getBody()).size();
        HttpRequest request2 = HttpRequest.builder(CompeticionApiController.COMPETICIONES).path(CompeticionApiController.ID)
                .expandPath(id).delete();
        new Client().submit(request2);
        assertTrue(((List<CompeticionIdNombreDto>) new Client().submit(request1).getBody()).size() < count);
    }

}
