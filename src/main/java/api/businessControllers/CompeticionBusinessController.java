package api.businessControllers;

import api.daos.DaoFactory;
import api.dtos.CompeticionDto;
import api.dtos.CompeticionIdNombreDto;
import api.entities.Competicion;

import java.util.List;
import java.util.stream.Collectors;

public class CompeticionBusinessController {

    public String create(CompeticionDto competicionDto){
        Competicion competicion = new Competicion(competicionDto.getNombre(), competicionDto.getFecha());
        DaoFactory.getFactory().getCompeticionDao().save(competicion);
        return competicion.getId();
    }

    public List<CompeticionIdNombreDto> readAll() {
        return DaoFactory.getFactory().getCompeticionDao().findAll()
                .stream().map(CompeticionIdNombreDto::new)
                .collect(Collectors.toList());
    }
}
