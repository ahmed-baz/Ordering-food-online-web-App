package net.web.app.senior.bll.transformer;

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
public class DeliveryAreaTransformer implements SeniorConstant, GeneralTransformer<DeliveryAreaEntity, DeliveryAreaBean> {

    @Autowired
    private AreaTransformer areaTransformer;
    @Autowired
    private BranchTransformer branchTransformer;

    public void setAreaTransformer(AreaTransformer areaTransformer) {
        this.areaTransformer = areaTransformer;
    }

    public void setBranchTransformer(BranchTransformer branchTransformer) {
        this.branchTransformer = branchTransformer;
    }

    @Override
    public DeliveryAreaEntity fromBeanToEntity(DeliveryAreaBean bean) {
        DeliveryAreaEntity entity = new DozerBeanMapper().map(bean, DeliveryAreaEntity.class);
        entity.setArea(areaTransformer.fromBeanToEntity(bean.getAreaBean()));
        entity.setBranch(branchTransformer.fromBeanToEntity(bean.getBranchBean()));
        return entity;
    }

    @Override
    public DeliveryAreaBean fromEntityToBean(DeliveryAreaEntity entity, String lang) {
        DeliveryAreaBean bean = new DozerBeanMapper().map(entity, DeliveryAreaBean.class);
        AreaEntity area = entity.getArea();
        BranchEntity branch = entity.getBranch();
        AreaBean areaBean = areaTransformer.fromEntityToBean(area, lang);
        BranchBean branchBean = branchTransformer.fromEntityToBean(branch, lang);
        bean.setAreaBean(areaBean);
        bean.setBranchBean(branchBean);
        return bean;
    }

}
