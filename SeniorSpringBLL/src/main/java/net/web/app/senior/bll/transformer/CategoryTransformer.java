package net.web.app.senior.bll.transformer;

import net.web.app.senior.beans.CategoryBean;
import net.web.app.senior.dal.entity.CategoryEntity;
import org.springframework.stereotype.Component;

@Component
public class CategoryTransformer implements GeneralTransformer<CategoryEntity, CategoryBean> {

    @Override
    public CategoryEntity fromBeanToEntity(CategoryBean bean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CategoryBean fromEntityToBean(CategoryEntity entity, String lang) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
