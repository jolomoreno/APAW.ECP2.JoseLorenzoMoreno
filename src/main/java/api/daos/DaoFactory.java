package api.daos;

public abstract class DaoFactory {

    private static DaoFactory factory = null;

    public static DaoFactory getFactory(){
        return factory;
    }

    public static void setFactory(DaoFactory factory){ DaoFactory.factory = factory; }

    public abstract CompeticionDao getCompeticionDao();

    public abstract EquipoDao getEquipoDao();
}
