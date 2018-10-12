package api.daos.memory;

import api.daos.CompeticionDao;
import api.daos.DaoFactory;

public class DaoMemoryFactory extends DaoFactory {

    private CompeticionDao competicionDao;

    @Override
    public CompeticionDao getCompeticionDao() {
        if(competicionDao == null) {
            competicionDao = new CompeticionDaoMemory();
        }
        return competicionDao;
    }
}
