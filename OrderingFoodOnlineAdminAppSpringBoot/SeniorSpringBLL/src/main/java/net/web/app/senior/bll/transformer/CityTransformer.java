package net.web.app.senior.bll.transformer;

import java.util.HashSet;
import java.util.Set;
import net.web.app.senior.beans.AreaBean;
import net.web.app.senior.beans.CityBean;
import net.web.app.senior.constant.SeniorConstant;
import net.web.app.senior.dal.entity.AreaEntity;
import net.web.app.senior.dal.entity.CityEntity;
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
        CityBean cityBean = new CityBean();
        cityBean.setId(entity.getId());
        cityBean.setNameAr(entity.getNameAr());
        cityBean.setNameEn(entity.getNameEn());
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
        CityEntity cityEntity = new CityEntity();
        cityEntity.setId(bean.getId());
        cityEntity.setNameAr(bean.getNameAr());
        cityEntity.setNameEn(bean.getNameEn());
        return cityEntity;
    }

    public CityEntity fromBeanToEntityWithArea(CityBean bean) {
        CityEntity cityEntity = fromBeanToEntity(bean);
        Set setOfAreaEntity = new HashSet<>();
        for (AreaBean areaBean : bean.getAreasBean()) {
            AreaEntity entity = areaTransformer.fromBeanToEntity(areaBean);
            setOfAreaEntity.add(entity);
        }
        cityEntity.setAreas(setOfAreaEntity);
        return cityEntity;
    }

}
