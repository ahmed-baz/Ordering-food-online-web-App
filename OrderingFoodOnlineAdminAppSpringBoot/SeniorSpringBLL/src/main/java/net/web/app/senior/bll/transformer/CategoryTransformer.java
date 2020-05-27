package net.web.app.senior.bll.transformer;

import net.web.app.senior.beans.CategoryBean;
import static net.web.app.senior.constant.SeniorConstant.LANG_EN;
import net.web.app.senior.dal.entity.CategoryEntity;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CategoryTransformer implements GeneralTransformer<CategoryEntity, CategoryBean> {

    @Autowired
    private ProviderTransformer providerTransformer;

    @Override
    public CategoryEntity fromBeanToEntity(CategoryBean bean) {
        CategoryEntity entity = new DozerBeanMapper().map(bean, CategoryEntity.class);
        entity.setProvider(providerTransformer.fromBeanToEntity(bean.getProviderBean()));
        return entity;
    }

    @Override
    public CategoryBean fromEntityToBean(CategoryEntity entity, String lang) {
        CategoryBean bean = new DozerBeanMapper().map(entity, CategoryBean.class);
        bean.setProviderBean(providerTransformer.fromEntityToBean(entity.getProvider(), LANG_EN));

        if (LANG_EN.equals(lang)) {
            bean.setName(entity.getNameEn());
            bean.setDescription(entity.getDescriptionEn());
        } else {
            bean.setName(entity.getNameAr());
            bean.setDescription(entity.getDescriptionAr());
        }

        return bean;
    }

}
