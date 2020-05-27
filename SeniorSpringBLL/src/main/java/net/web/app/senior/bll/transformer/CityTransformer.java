package net.web.app.senior.bll.transformer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import net.web.app.senior.beans.AreaBean;
import net.web.app.senior.beans.CityBean;
import net.web.app.senior.constant.SeniorConstant;
import net.web.app.senior.dal.entity.AreaEntity;
import net.web.app.senior.dal.entity.CityEntity;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CityTransformer implements SeniorConstant, GeneralTransformer<CityEntity, CityBean> {

    @Autowired
    private AreaTransformer areaTransformer;

    public void setAreaTransformer(AreaTransformer areaTransformer) {
        this.areaTransformer = areaTransformer;
    }

    @Override
    public CityBean fromEntityToBean(CityEntity entity, String lang) {
        CityBean cityBean = new DozerBeanMapper().map(entity, CityBean.class);
        return cityBean;
    }

    public CityBean fromEntityToBeanWithAreas(CityEntity entity, String lang) {
        CityBean cityBean = fromEntityToBean(entity, lang);
        Set setOfAreas = new HashSet<>();
        for (AreaEntity area : entity.getAreas()) {
            AreaBean fromEntityToBean = areaTransformer.fromEntityToBean(area, lang);
            setOfAreas.add(fromEntityToBean);
        }
        cityBean.setAreasBean(setOfAreas);
        return cityBean;
    }

    @Override
    public CityEntity fromBeanToEntity(CityBean bean) {
        CityEntity cityEntity = new DozerBeanMapper().map(bean, CityEntity.class);
        return cityEntity;
    }

}
