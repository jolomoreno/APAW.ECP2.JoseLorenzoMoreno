package api.apiControllers;

import api.businessControllers.CompeticionBusinessController;
import api.dtos.CompeticionDto;
import api.dtos.CompeticionIdNombreDto;
import api.exceptions.ArgumentNotValidException;

import java.util.List;

public class CompeticionApiController {

    public static final String COMPETICIONES = "/competiciones";

    public static final String ID = "/{id}";

    private CompeticionBusinessController competicionBusinessController = new CompeticionBusinessController();

    private void validate(Object property, String message) {
        if (property == null) {
            throw new ArgumentNotValidException(message + " is missing");
        }
    }

    public String create(CompeticionDto competicionDto){
        this.validate(competicionDto, "competicionDto");
        this.validate(competicionDto.getNombre(), "CompeticionDto Nombre");
        return this.competicionBusinessController.create(competicionDto);
    }

    public List<CompeticionIdNombreDto> readAll() {
        return this.competicionBusinessController.readAll();
    }

    public void update(String id, CompeticionDto competicionDto){
        this.validate(competicionDto, "competicionDto");
        this.validate(competicionDto.getNombre(), "CompeticionDto Nombre");
        this.competicionBusinessController.updateNombre(id, competicionDto);
    }
}
