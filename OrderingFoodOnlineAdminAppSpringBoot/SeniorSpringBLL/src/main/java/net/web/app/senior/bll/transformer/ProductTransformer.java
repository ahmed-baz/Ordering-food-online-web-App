package net.web.app.senior.bll.transformer;

import net.web.app.senior.beans.ProductBean;
import net.web.app.senior.constant.SeniorConstant;
import net.web.app.senior.dal.entity.ProductEntity;
import org.dozer.DozerBeanMapper;
import org.springframework.stereotype.Component;

@Component
public class ProductTransformer implements SeniorConstant, GeneralTransformer<ProductEntity, ProductBean> {

    @Override
    public ProductEntity fromBeanToEntity(ProductBean bean) {
        ProductEntity productEntity = new DozerBeanMapper().map(bean, ProductEntity.class);
        return productEntity;
    }

    @Override
    public ProductBean fromEntityToBean(ProductEntity entity, String lang) {
        ProductBean productBean = new DozerBeanMapper().map(entity, ProductBean.class);
        return productBean;
    }

}
