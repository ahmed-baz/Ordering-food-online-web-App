package net.web.app.senior.bll.transformer;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.web.app.senior.beans.AreaBean;
import net.web.app.senior.beans.BranchBean;
import net.web.app.senior.beans.DeliveryAreaBean;
import net.web.app.senior.bll.manager.impl.ProviderManagerImpl;
import net.web.app.senior.constant.SeniorConstant;
import net.web.app.senior.dal.entity.AreaEntity;
import net.web.app.senior.dal.entity.BranchEntity;
import net.web.app.senior.dal.entity.DeliveryAreaEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BranchTransformer implements SeniorConstant, GeneralTransformer<BranchEntity, BranchBean> {

    @Autowired
    private DeliveryAreaTransformer deliveryAreaTransformer;
    @Autowired
    private ProviderTransformer providerTransformer;
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
        Date openAt = new Date();
        Date closeAt = new Date();
        try {
            openAt = new SimpleDateFormat("hh:mm:ss a").parse(bean.getOpenAt());
            closeAt = new SimpleDateFormat("hh:mm:ss a").parse(bean.getCloseAt());
        } catch (ParseException ex) {
            System.out.println(" ........ Can't parse date ........ ");
        }
        BranchEntity entity = new BranchEntity();
        entity.setId(bean.getId());
        entity.setNameAr(bean.getNameAr());
        entity.setNameEn(bean.getNameEn());
        entity.setPhone(bean.getPhone());
        entity.setLat(bean.getLat());
        entity.setLng(bean.getLng());
        entity.setOpenAt(openAt);
        entity.setCloseAt(closeAt);
        entity.setArea(areaTransformer.fromBeanToEntity(bean.getArea()));
        entity.setProvider(providerTransformer.fromBeanToEntity(bean.getProvider()));
        return entity;
    }

    public void setProviderTransformer(ProviderTransformer providerTransformer) {
        this.providerTransformer = providerTransformer;
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
        DateFormat dateFormat = new SimpleDateFormat("hh:mm:ss a");
        BranchBean bean = new BranchBean();
        bean.setId(entity.getId());
        bean.setNameAr(entity.getNameAr());
        bean.setNameEn(entity.getNameEn());
        bean.setOpenAt(dateFormat.format(entity.getOpenAt()));
        bean.setCloseAt(dateFormat.format(entity.getCloseAt()));
        bean.setPhone(entity.getPhone());
        bean.setLat(entity.getLat());
        bean.setLng(entity.getLng());
        bean.setArea(areaTransformer.fromEntityToBean(entity.getArea(), lang));
        bean.setProvider(providerTransformer.fromEntityToBean(entity.getProvider(), lang));
        return bean;
    }

    public BranchBean fromEntityToBeanWithDetails(BranchEntity entity, String lang) {
        BranchBean bean = fromEntityToBean(entity, lang);
        Set<DeliveryAreaEntity> deliveryAreas = entity.getDeliveryAreas();
        Set<DeliveryAreaBean> deliveryAreasBeans = new HashSet<>();
        for (DeliveryAreaEntity deliveryArea : deliveryAreas) {
            DeliveryAreaBean deliveryAreaBean = deliveryAreaTransformer.fromEntityToBean(deliveryArea, lang);
            deliveryAreasBeans.add(deliveryAreaBean);
        }
        bean.setDeliveryAreas(deliveryAreasBeans);
        return bean;
    }

}
