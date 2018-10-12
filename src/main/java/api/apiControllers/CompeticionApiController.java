package api.apiControllers;

import api.businessControllers.CompeticionBusinessController;
import api.dtos.CompeticionDto;
import api.exceptions.ArgumentNotValidException;

public class CompeticionApiController {

    public static final String COMPETICIONES = "/competiciones";

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
}
