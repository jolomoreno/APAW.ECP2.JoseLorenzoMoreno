package api.apiControllers;

import api.businessControllers.EquipoBussinessController;
import api.dtos.EquipoDto;
import api.dtos.EquipoIdNombreDto;
import api.entities.Categoria;
import api.exceptions.ArgumentNotValidException;

import java.util.List;

public class EquipoApiController {

    public static final String EQUIPOS = "/equipos";

    public static final String ID = "/{id}";

    public static final String CATEGORIA = "/categoria";

    public static final String SEARCH = "/search";

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

    public void updateCategoria(String equipoId, Categoria categoria) {
        this.validate(categoria, "categoria");
        this.equipoBusinessController.updateCategoria(equipoId, categoria);
    }

    public List<EquipoIdNombreDto> find(String query) {
        this.validate(query, "query param q");
        if (!"categoria".equals(query.split(":==")[0])) {
            throw new ArgumentNotValidException("query param q is incorrect, missing 'categoria:=='");
        }
        return this.equipoBusinessController.findByCategoriaEqualsJUNIOR(query.split(":==")[1]);
    }
}
