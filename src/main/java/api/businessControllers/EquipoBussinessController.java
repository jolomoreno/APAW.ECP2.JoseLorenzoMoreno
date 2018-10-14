package api.businessControllers;

import api.daos.DaoFactory;
import api.dtos.CompeticionIdNombreDto;
import api.dtos.EquipoDto;
import api.dtos.EquipoIdNombreDto;
import api.entities.Categoria;
import api.entities.Competicion;
import api.entities.Equipo;
import api.exceptions.NotFoundException;

import java.util.List;
import java.util.stream.Collectors;

public class EquipoBussinessController {

    public String create(EquipoDto equipoDto) {
        Competicion competicion = null;
        if (equipoDto.getCompeticionId() != null) {
            competicion = DaoFactory.getFactory().getCompeticionDao().read(equipoDto.getCompeticionId())
                    .orElseThrow(() -> new NotFoundException("Competicion (" + equipoDto.getCompeticionId() + ")"));
        }
        Equipo equipo = Equipo.builder(equipoDto.getNombre()).competicion(competicion).categoria(equipoDto.getCategoria()).build();
        DaoFactory.getFactory().getEquipoDao().save(equipo);
        return equipo.getId();
    }

    public List<EquipoIdNombreDto> readAll() {
        return DaoFactory.getFactory().getEquipoDao().findAll()
                .stream().map(EquipoIdNombreDto::new)
                .collect(Collectors.toList());
    }

    public void updateCategoria(String equipoId, Categoria categoria) {
        Equipo equipo = DaoFactory.getFactory().getEquipoDao().read(equipoId)
                .orElseThrow(() -> new NotFoundException("Equipo (" + equipoId + ")"));
        equipo.setCategoria(categoria);
        DaoFactory.getFactory().getEquipoDao().save(equipo);
    }

    private String getCategoria(Equipo equipo) {
        return equipo.getCategoria().toString();
    }

    public List<EquipoIdNombreDto> findByCategoriaEqualsJUNIOR(String categoriaValue) {
        return DaoFactory.getFactory().getEquipoDao().findAll()
                .stream()
                .filter(equipo -> this.getCategoria(equipo).equals(categoriaValue))
                .map(EquipoIdNombreDto::new)
                .collect(Collectors.toList());
    }
}
