package net.web.app.senior.bll.transformer;

import java.util.HashSet;
import java.util.Set;
import net.web.app.senior.beans.BranchBean;
import net.web.app.senior.beans.CategoryBean;
import net.web.app.senior.beans.ProviderBean;
import net.web.app.senior.constant.SeniorConstant;
import net.web.app.senior.dal.entity.BranchEntity;
import net.web.app.senior.dal.entity.ProviderEntity;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProviderTransformer implements SeniorConstant, GeneralTransformer<ProviderEntity, ProviderBean> {

    @Autowired
    private BranchTransformer branchTransformer;

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
        ProviderBean bean = new DozerBeanMapper().map(entity, ProviderBean.class);
        Set<BranchEntity> branches = entity.getBranches();
        Set<BranchBean> brancheBeanSet = new HashSet<>();
        Set<CategoryBean> categoryBeanSet = new HashSet<>();
        for (BranchEntity branche : branches) {
            BranchBean branchBean = branchTransformer.fromEntityToBeanWithDeliveryAreas(branche, lang);
            brancheBeanSet.add(branchBean);
        }
        bean.setBranchesBean(brancheBeanSet);
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
