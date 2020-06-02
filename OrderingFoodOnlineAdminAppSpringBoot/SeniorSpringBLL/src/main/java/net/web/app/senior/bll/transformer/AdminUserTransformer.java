package net.web.app.senior.bll.transformer;

import net.web.app.senior.beans.AdminUserBean;
import net.web.app.senior.dal.entity.AdminUserEntity;
import org.dozer.DozerBeanMapper;
import org.springframework.stereotype.Component;

@Component
public class AdminUserTransformer implements GeneralTransformer<AdminUserEntity, AdminUserBean> {

    @Override
    public AdminUserEntity fromBeanToEntity(AdminUserBean bean) {
        AdminUserEntity entity = new DozerBeanMapper().map(bean, AdminUserEntity.class);
        return entity;
    }

    @Override
    public AdminUserBean fromEntityToBean(AdminUserEntity entity, String lang) {
        AdminUserBean bean = new DozerBeanMapper().map(entity, AdminUserBean.class);
        return bean;
    }

}
