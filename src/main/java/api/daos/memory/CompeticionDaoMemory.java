package api.daos.memory;

import api.daos.CompeticionDao;
import api.entities.Competicion;

import java.util.HashMap;

public class CompeticionDaoMemory extends GenericDaoMemory<Competicion> implements CompeticionDao{

    public CompeticionDaoMemory(){ super(new HashMap<>());}

    @Override
    public String getId(Competicion competicion){
        return competicion.getId();
    }

    @Override
    public void setId(Competicion competicion, String id){
        competicion.setId(id);
    }
}
