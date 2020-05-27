package net.web.app.senior.bll.transformer;

import net.web.app.senior.beans.AreaBean;
import net.web.app.senior.beans.CityBean;
import net.web.app.senior.constant.SeniorConstant;
import net.web.app.senior.dal.entity.AreaEntity;
import net.web.app.senior.dal.entity.CityEntity;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AreaTransformer implements SeniorConstant, GeneralTransformer<AreaEntity, AreaBean> {

    @Autowired
    private CityTransformer cityTransformer;

    @Override
    public AreaEntity fromBeanToEntity(AreaBean bean) {
        AreaEntity entity = new DozerBeanMapper().map(bean, AreaEntity.class);
        CityEntity cityEntity = new DozerBeanMapper().map(bean.getCityBean(), CityEntity.class);
        entity.setCity(cityEntity);
        return entity;
    }

    public void setCityTransformer(CityTransformer cityTransformer) {
        this.cityTransformer = cityTransformer;
    }

    @Override
    public AreaBean fromEntityToBean(AreaEntity entity, String lang) {
        AreaBean bean = new DozerBeanMapper().map(entity, AreaBean.class);
        if (LANG_AR.equals(lang)) {
            bean.setName(entity.getNameAr());
        } else {
            bean.setName(entity.getNameEn());
        }
        return bean;
    }

    public AreaBean fromEntityToBeanWithCity(AreaEntity entity, String lang) {
        AreaBean bean = fromEntityToBean(entity, lang);
        CityEntity cityEntity = entity.getCity();
        CityBean cityBean = cityTransformer.fromEntityToBean(cityEntity, lang);
        bean.setCityBean(cityBean);
        return bean;
    }

}
