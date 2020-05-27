package net.web.app.senior.bll.transformer;

import java.util.HashSet;
import java.util.Set;
import net.web.app.senior.beans.AreaBean;
import net.web.app.senior.beans.BranchBean;
import net.web.app.senior.beans.DeliveryAreaBean;
import net.web.app.senior.constant.SeniorConstant;
import net.web.app.senior.dal.entity.AreaEntity;
import net.web.app.senior.dal.entity.BranchEntity;
import net.web.app.senior.dal.entity.DeliveryAreaEntity;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BranchTransformer implements SeniorConstant, GeneralTransformer<BranchEntity, BranchBean> {

    @Autowired
    private DeliveryAreaTransformer deliveryAreaTransformer;
    @Autowired
    private AreaTransformer areaTransformer;

    public void setDeliveryAreaTransformer(DeliveryAreaTransformer deliveryAreaTransformer) {
        this.deliveryAreaTransformer = deliveryAreaTransformer;
    }

    public void setAreaTransformer(AreaTransformer areaTransformer) {
        this.areaTransformer = areaTransformer;
    }

    @Override
    public BranchEntity fromBeanToEntity(BranchBean bean) {
        BranchEntity entity = new DozerBeanMapper().map(bean, BranchEntity.class);
        return entity;
    }

    public BranchEntity fromBeanToEntityWithDeliveryAreas(BranchBean bean) {
        BranchEntity branchEntity = fromBeanToEntity(bean);
        Set<DeliveryAreaEntity> deliveryAreaEntitys = new HashSet<>();
        Set<DeliveryAreaBean> deliveryAreas = bean.getDeliveryAreas();
        for (DeliveryAreaBean deliveryArea : deliveryAreas) {
            DeliveryAreaEntity entity = deliveryAreaTransformer.fromBeanToEntity(deliveryArea);
            deliveryAreaEntitys.add(entity);
        }
        branchEntity.setDeliveryAreas(deliveryAreaEntitys);
        return branchEntity;
    }

    @Override
    public BranchBean fromEntityToBean(BranchEntity entity, String lang) {
        BranchBean bean = new DozerBeanMapper().map(entity, BranchBean.class);
        return bean;
    }

    public BranchBean fromEntityToBeanWithDeliveryAreas(BranchEntity entity, String lang) {
        BranchBean bean = fromEntityToBean(entity, lang);
        Set<DeliveryAreaEntity> deliveryAreas = entity.getDeliveryAreas();
        AreaEntity area = entity.getArea();
        AreaBean areaBean = areaTransformer.fromEntityToBeanWithCity(area, lang);
        bean.setArea(areaBean);
        Set<DeliveryAreaBean> deliveryAreasBeans = new HashSet<>();
        for (DeliveryAreaEntity deliveryArea : deliveryAreas) {
            DeliveryAreaBean deliveryAreaBean = deliveryAreaTransformer.fromEntityToBean(deliveryArea, lang);
            deliveryAreasBeans.add(deliveryAreaBean);
        }
        bean.setDeliveryAreas(deliveryAreasBeans);
        return bean;
    }

}
