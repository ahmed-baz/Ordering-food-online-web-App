package net.web.app.senior.dal.repo;

import java.util.List;
import net.web.app.senior.dal.entity.AreaEntity;

public interface AreaRepo extends CommonRepo<AreaEntity> {

    public void removeAllList();

    public List<AreaEntity> findAreaListByCityId(Integer id);

}
