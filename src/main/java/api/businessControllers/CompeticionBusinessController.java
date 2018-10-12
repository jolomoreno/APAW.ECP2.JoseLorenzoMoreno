package api.businessControllers;

import api.daos.DaoFactory;
import api.dtos.CompeticionDto;
import api.entities.Competicion;

public class CompeticionBusinessController {

    public String create(CompeticionDto competicionDto){
        Competicion competicion = new Competicion(competicionDto.getNombre(), competicionDto.getFecha());
        DaoFactory.getFactory().getCompeticionDao().save(competicion);
        return competicion.getId();
    }
}
