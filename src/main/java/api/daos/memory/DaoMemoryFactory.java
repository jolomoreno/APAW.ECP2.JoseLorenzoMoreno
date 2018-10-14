package api.daos.memory;

import api.daos.CompeticionDao;
import api.daos.DaoFactory;
import api.daos.EquipoDao;

public class DaoMemoryFactory extends DaoFactory {

    private CompeticionDao competicionDao;

    private EquipoDao equipoDao;

    @Override
    public CompeticionDao getCompeticionDao() {
        if(competicionDao == null) {
            competicionDao = new CompeticionDaoMemory();
        }
        return competicionDao;
    }

    @Override
    public EquipoDao getEquipoDao() {
        if(equipoDao == null) {
            equipoDao = new EquipoDaoMemory();
        }
        return equipoDao;
    }
}
