package api;

import api.apiControllers.CompeticionApiController;
import api.apiControllers.EquipoApiController;
import api.dtos.CompeticionDto;
import api.dtos.EquipoDto;
import api.entities.Categoria;
import http.Client;
import http.HttpRequest;
import org.junit.jupiter.api.Test;

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
}
