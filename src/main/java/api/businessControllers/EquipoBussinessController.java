package api.businessControllers;

import api.daos.DaoFactory;
import api.dtos.EquipoDto;
import api.entities.Competicion;
import api.entities.Equipo;
import api.exceptions.NotFoundException;

public class EquipoBussinessController {

    public String create(EquipoDto equipoDto) {
        Competicion competicion = null;
        if (equipoDto.getCompeticionId() != null) {
            competicion = DaoFactory.getFactory().getCompeticionDao().read(equipoDto.getCompeticionId())
                    .orElseThrow(() -> new NotFoundException("User (" + equipoDto.getCompeticionId() + ")"));
        }
        Equipo equipo = Equipo.builder(equipoDto.getNombre()).competicion(competicion).categoria(equipoDto.getCategoria()).build();
        DaoFactory.getFactory().getEquipoDao().save(equipo);
        return equipo.getId();
    }
}
