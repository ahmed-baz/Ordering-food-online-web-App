package net.web.app.senior.bll.transformer;

import net.web.app.senior.beans.AdminUserBean;
import net.web.app.senior.dal.entity.AdminUserEntity;
import org.springframework.stereotype.Component;


@Component
public class AdminUserTransformer implements GeneralTransformer<AdminUserEntity, AdminUserBean> {

    @Override
    public AdminUserEntity fromBeanToEntity(AdminUserBean bean) {
        AdminUserEntity entity = new AdminUserEntity();
        entity.setId(bean.getId());
        entity.setUsername(bean.getUsername());
        entity.setPassword(bean.getPassword());
        return entity;
    }

    @Override
    public AdminUserBean fromEntityToBean(AdminUserEntity entity, String lang) {
        AdminUserBean bean = new AdminUserBean();

        bean.setId(entity.getId());
        bean.setUsername(entity.getUsername());
        bean.setPassword(entity.getPassword());

        return bean;
    }

}
