package api;

import api.apiControllers.CompeticionApiController;
import api.dtos.CompeticionDto;
import http.Client;
import http.HttpRequest;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

public class CompeticionIT {

    @Test
    void testCreateCompeticion() {
        this.createCompeticion();
    }

    private String createCompeticion() {
        HttpRequest request = HttpRequest.builder(CompeticionApiController.COMPETICIONES).body(new CompeticionDto("La Vuelta")).post();
        return (String) new Client().submit(request).getBody();
    }
}
