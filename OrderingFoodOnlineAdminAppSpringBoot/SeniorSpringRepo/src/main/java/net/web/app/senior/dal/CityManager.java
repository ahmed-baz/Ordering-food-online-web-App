
package net.web.app.senior.dal;

import java.util.List;
import net.web.app.senior.dal.entity.CityEntity;
import net.web.app.senior.dal.repo.CityRepo;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CityManager {

    @Transactional
    public List<CityEntity> findCityList(ApplicationContext appCon) {
        CityRepo bean = appCon.getBean("cityRepoImpl", CityRepo.class);
        List<CityEntity> list = bean.findList();
        return list;
    }

    @Transactional
    public CityEntity findCityById(ApplicationContext appCon, Integer id) {
        CityRepo bean = appCon.getBean("cityRepoImpl", CityRepo.class);
        return bean.findById(id);
    }

    @Transactional
    public CityEntity addCity(ApplicationContext appCon, CityEntity entity) {
        CityRepo bean = appCon.getBean("cityRepoImpl", CityRepo.class);
        return bean.add(entity);
    }
}
