package net.web.app.senior.bll.transformer;

import java.util.HashSet;
import java.util.Set;
import net.web.app.senior.beans.AreaBean;
import net.web.app.senior.beans.BranchBean;
import net.web.app.senior.beans.DeliveryAreaBean;
import net.web.app.senior.beans.OrderBean;
import net.web.app.senior.constant.SeniorConstant;
import net.web.app.senior.dal.entity.AreaEntity;
import net.web.app.senior.dal.entity.BranchEntity;
import net.web.app.senior.dal.entity.CityEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AreaTransformer implements SeniorConstant, GeneralTransformer<AreaEntity, AreaBean> {

    @Autowired
    private CityTransformer cityTransformer;
    @Autowired
    private BranchTransformer branchTransformer;
    @Autowired
    private DeliveryAreaTransformer deliveryAreaTransformer;
    @Autowired
    private OrderTransformer orderTransformer;

    public void setDeliveryAreaTransformer(DeliveryAreaTransformer deliveryAreaTransformer) {
        this.deliveryAreaTransformer = deliveryAreaTransformer;
    }

    @Override
    public AreaEntity fromBeanToEntity(AreaBean bean) {
        AreaEntity entity = new AreaEntity();
        CityEntity cityEntity = cityTransformer.fromBeanToEntity(bean.getCityBean());
        entity.setId(bean.getId());
        entity.setNameAr(bean.getNameAr());
        entity.setNameEn(bean.getNameEn());
        entity.setCity(cityEntity);
        return entity;
    }

    public AreaEntity fromBeanToEntityWithBranch(AreaBean bean) {
        AreaEntity entity = fromBeanToEntity(bean);
        CityEntity cityEntity = cityTransformer.fromBeanToEntity(bean.getCityBean());
        Set<BranchEntity> branches = new HashSet<>();
        bean.getBranchesBean().forEach(
                branchBean
                -> branches.add(branchTransformer.fromBeanToEntity(branchBean))
        );
        entity.setBranches(branches);
        return entity;
    }

    public void setBranchTransformer(BranchTransformer branchTransformer) {
        this.branchTransformer = branchTransformer;
    }

    public void setCityTransformer(CityTransformer cityTransformer) {
        this.cityTransformer = cityTransformer;
    }

    @Override
    public AreaBean fromEntityToBean(AreaEntity entity, String lang) {
        AreaBean bean = new AreaBean();
        bean.setId(entity.getId());
        bean.setNameAr(entity.getNameAr());
        bean.setNameEn(entity.getNameEn());
        bean.setCityBean(cityTransformer.fromEntityToBean(entity.getCity(), lang));
        if (LANG_AR.equals(lang)) {
            bean.setName(entity.getNameAr());
        } else {
            bean.setName(entity.getNameEn());
        }
        return bean;
    }

    public AreaBean fromEntityToBeanWithDetails(AreaEntity entity, String lang) {
        AreaBean bean = fromEntityToBean(entity, lang);

        Set<BranchBean> branchesBean = new HashSet<>();
        Set<DeliveryAreaBean> deliveryAreas = new HashSet<>();
        Set<OrderBean> ordersBean = new HashSet<>();

        entity.getBranches().forEach(branchEntity -> {
            branchesBean.add(branchTransformer.fromEntityToBean(branchEntity, lang));
        });

        entity.getDeliveryAreas().forEach(deliveryAreaEntity -> {
            deliveryAreas.add(deliveryAreaTransformer.fromEntityToBean(deliveryAreaEntity, lang));
        });

        entity.getOrders().forEach(orderEntity -> {
            ordersBean.add(orderTransformer.fromEntityToBean(orderEntity, lang)
            );
        });

        bean.setBranchesBean(branchesBean);
        return bean;
    }

    public void setOrderTransformer(OrderTransformer orderTransformer) {
        this.orderTransformer = orderTransformer;
    }

}
