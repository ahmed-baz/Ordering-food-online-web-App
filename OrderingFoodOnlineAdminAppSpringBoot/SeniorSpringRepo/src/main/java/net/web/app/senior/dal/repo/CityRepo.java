package net.web.app.senior.dal.repo;

import java.util.List;
import net.web.app.senior.dal.entity.CityEntity;

public interface CityRepo extends CommonRepo<CityEntity> {
    public List<CityEntity> searchByName(String keyword);
    public void removeAllList();
    
}