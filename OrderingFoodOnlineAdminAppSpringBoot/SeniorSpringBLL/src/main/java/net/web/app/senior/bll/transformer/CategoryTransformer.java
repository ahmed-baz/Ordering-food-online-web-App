package net.web.app.senior.bll.transformer;

import java.util.HashSet;
import java.util.Set;
import net.web.app.senior.beans.CategoryBean;
import net.web.app.senior.beans.ProductBean;
import static net.web.app.senior.constant.SeniorConstant.LANG_EN;
import net.web.app.senior.dal.entity.CategoryEntity;
import net.web.app.senior.dal.entity.ProductEntity;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CategoryTransformer implements GeneralTransformer<CategoryEntity, CategoryBean> {

    @Autowired
    private ProviderTransformer providerTransformer;
    @Autowired
    private ProductTransformer productTransformer;

    public void setProviderTransformer(ProviderTransformer providerTransformer) {
        this.providerTransformer = providerTransformer;
    }

    public void setProductTransformer(ProductTransformer productTransformer) {
        this.productTransformer = productTransformer;
    }

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

    public CategoryBean fromEntityToBeanWithproducts(CategoryEntity entity, String lang) {
        CategoryBean bean = fromEntityToBean(entity, lang);
        Set<ProductEntity> products = entity.getProducts();
        Set<ProductBean> productsBean = new HashSet<>();
        products.forEach(iEntity -> productsBean.add(productTransformer.fromEntityToBean(iEntity, lang)));
        bean.setProductsBean(productsBean);
        return bean;
    }

}
