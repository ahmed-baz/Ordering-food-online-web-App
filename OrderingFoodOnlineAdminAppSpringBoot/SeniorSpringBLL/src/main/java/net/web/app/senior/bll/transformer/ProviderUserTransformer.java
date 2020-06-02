package net.web.app.senior.bll.transformer;

import net.web.app.senior.beans.ProviderUsersBean;
import net.web.app.senior.dal.entity.ProviderUserEntity;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProviderUserTransformer implements GeneralTransformer<ProviderUserEntity, ProviderUsersBean> {

    @Autowired
    private BranchTransformer branchTransformer;
    @Autowired
    private ProviderTransformer providerTransformer;

    @Override
    public ProviderUserEntity fromBeanToEntity(ProviderUsersBean bean) {
        ProviderUserEntity entity = new DozerBeanMapper().map(bean, ProviderUserEntity.class);
        entity.setProvider(providerTransformer.fromBeanToEntity(bean.getProvider()));
        entity.setBranch(branchTransformer.fromBeanToEntity(bean.getBranch()));
        return entity;
    }

    @Override
    public ProviderUsersBean fromEntityToBean(ProviderUserEntity entity, String lang) {
        ProviderUsersBean bean = new ProviderUsersBean();
        bean.setId(entity.getId());
        bean.setUsername(entity.getUsername());
        bean.setPassword(entity.getPassword());
        bean.setActive(entity.getActive());
        bean.setProvider(providerTransformer.fromEntityToBean(entity.getProvider(), lang));
        bean.setBranch(branchTransformer.fromEntityToBean(entity.getBranch(), lang));
        return bean;
    }

}
