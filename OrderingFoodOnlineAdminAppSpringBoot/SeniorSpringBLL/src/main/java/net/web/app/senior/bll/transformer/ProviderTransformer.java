package net.web.app.senior.bll.transformer;

import java.util.HashSet;
import java.util.Set;
import net.web.app.senior.beans.BranchBean;
import net.web.app.senior.beans.CategoryBean;
import net.web.app.senior.beans.ProviderBean;
import net.web.app.senior.beans.ProviderUsersBean;
import net.web.app.senior.constant.SeniorConstant;
import net.web.app.senior.dal.entity.BranchEntity;
import net.web.app.senior.dal.entity.CategoryEntity;
import net.web.app.senior.dal.entity.ProviderEntity;
import net.web.app.senior.dal.entity.ProviderUserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProviderTransformer implements SeniorConstant, GeneralTransformer<ProviderEntity, ProviderBean> {

    @Autowired
    private BranchTransformer branchTransformer;
    @Autowired
    private CategoryTransformer categoryTransformer;
    @Autowired
    private ProviderUserTransformer providerUserTransformer;

    public void setBranchTransformer(BranchTransformer branchTransformer) {
        this.branchTransformer = branchTransformer;
    }

    @Override
    public ProviderEntity fromBeanToEntity(ProviderBean bean) {
        ProviderEntity entity = new ProviderEntity();
        entity.setId(bean.getId());
        entity.setNameAr(bean.getNameAr());
        entity.setNameEn(bean.getNameEn());
        entity.setHotline(bean.getHotline());
        entity.setLogoPathAr(bean.getLogoPathAr());
        entity.setLogoPathEn(bean.getLogoPathEn());
        return entity;
    }

    @Override
    public ProviderBean fromEntityToBean(ProviderEntity entity, String lang) {
        ProviderBean bean = new ProviderBean();
        bean.setId(entity.getId());
        bean.setNameAr(entity.getNameAr());
        bean.setNameEn(entity.getNameEn());
        bean.setHotline(entity.getHotline());
        bean.setLogoPathAr(entity.getLogoPathAr());
        bean.setLogoPathEn(entity.getLogoPathEn());
        if (LANG_EN.equals(lang)) {
            bean.setName(entity.getNameEn());
            bean.setDefaultLogoPath(entity.getLogoPathEn());
        } else {
            bean.setName(entity.getNameAr());
            bean.setDefaultLogoPath(entity.getLogoPathAr());
        }
        return bean;
    }

    public ProviderBean fromEntityToBeanWithDetails(ProviderEntity entity, String lang) {
        ProviderBean bean = fromEntityToBean(entity, lang);
        Set<BranchEntity> branches = entity.getBranches();
        Set<CategoryEntity> categories = entity.getCategories();
        Set<ProviderUserEntity> providerUsers = entity.getProviderUsers();
        Set<BranchBean> brancheBeanSet = new HashSet<>();
        Set<CategoryBean> categoryBeanSet = new HashSet<>();
        Set<ProviderUsersBean> providerUsersBeanSet = new HashSet<>();
        for (BranchEntity branche : branches) {
            BranchBean branchBean = branchTransformer.fromEntityToBean(branche, lang);
            brancheBeanSet.add(branchBean);
        }
        for (CategoryEntity category : categories) {
            CategoryBean categoryBean = categoryTransformer.fromEntityToBean(category, lang);
            categoryBeanSet.add(categoryBean);
        }
        for (ProviderUserEntity providerUser : providerUsers) {
            ProviderUsersBean providerUsersBean = providerUserTransformer.fromEntityToBean(providerUser, lang);
            providerUsersBeanSet.add(providerUsersBean);
        }
        bean.setBranchesBean(brancheBeanSet);
        bean.setCategoriesBean(categoryBeanSet);
        bean.setProviderUsersBean(providerUsersBeanSet);

        if (LANG_EN.equals(lang)) {
            bean.setName(entity.getNameEn());
            bean.setDefaultLogoPath(entity.getLogoPathEn());
        } else {
            bean.setName(entity.getNameAr());
            bean.setDefaultLogoPath(entity.getLogoPathAr());
        }
        return bean;
    }

}
