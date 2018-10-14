package api.daos.memory;

import api.daos.EquipoDao;
import api.entities.Equipo;

import java.util.HashMap;

public class EquipoDaoMemory extends GenericDaoMemory<Equipo> implements EquipoDao {

    public EquipoDaoMemory(){ super(new HashMap<>());}

    @Override
    public String getId(Equipo equipo){
        return equipo.getId();
    }

    @Override
    public void setId(Equipo equipo, String id){
        equipo.setId(id);
    }
}
