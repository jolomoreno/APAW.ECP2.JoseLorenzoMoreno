package api.apiControllers;

import api.businessControllers.EquipoBussinessController;
import api.dtos.EquipoDto;
import api.dtos.EquipoIdNombreDto;
import api.exceptions.ArgumentNotValidException;

import java.util.List;

public class EquipoApiController {

    public static final String EQUIPOS = "/equipos";

    private EquipoBussinessController equipoBusinessController = new EquipoBussinessController();

    private void validate(Object property, String message) {
        if (property == null) {
            throw new ArgumentNotValidException(message + " is missing");
        }
    }

    public String create(EquipoDto equipoDto) {
        this.validate(equipoDto, "equipoDto");
        this.validate(equipoDto.getNombre(), "equipoDto nombre");
        return this.equipoBusinessController.create(equipoDto);
    }

    public List<EquipoIdNombreDto> readAll() {
        return this.equipoBusinessController.readAll();
    }
}
