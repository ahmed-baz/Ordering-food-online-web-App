package net.web.app.senior.bll.manager.impl;

import java.util.ArrayList;
import java.util.List;
import net.web.app.senior.beans.BranchBean;
import net.web.app.senior.beans.DeliveryAreaBean;
import net.web.app.senior.beans.CategoryBean;
import net.web.app.senior.beans.ProviderBean;
import net.web.app.senior.beans.ProviderUsersBean;
import net.web.app.senior.bll.manager.ProviderManager;
import net.web.app.senior.bll.transformer.ProviderTransformer;
import net.web.app.senior.bll.transformer.ProviderUserTransformer;
import net.web.app.senior.bll.transformer.BranchTransformer;
import net.web.app.senior.bll.transformer.CategoryTransformer;
import net.web.app.senior.bll.transformer.DeliveryAreaTransformer;
import net.web.app.senior.constant.SeniorConstant;
import net.web.app.senior.dal.entity.BranchEntity;
import net.web.app.senior.dal.entity.CategoryEntity;
import net.web.app.senior.dal.entity.DeliveryAreaEntity;
import net.web.app.senior.dal.entity.ProviderEntity;
import net.web.app.senior.dal.entity.ProviderUserEntity;
import net.web.app.senior.dal.repo.ProviderRepo;
import net.web.app.senior.dal.repo.ProviderUserRepo;
import net.web.app.senior.dal.repo.BranchRepo;
import net.web.app.senior.dal.repo.CategoryRepo;
import net.web.app.senior.dal.repo.DeliveryAreaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProviderManagerImpl implements ProviderManager, SeniorConstant {

    @Autowired
    private ProviderRepo providerRepo;
    @Autowired
    private ProviderUserRepo providerUserRepo;
    @Autowired
    private BranchRepo branchRepo;
    @Autowired
    private CategoryRepo categoryRepo;
    @Autowired
    private DeliveryAreaRepo deliveryAreaRepo;
    @Autowired
    private ProviderTransformer providerTransformer;
    @Autowired
    private ProviderUserTransformer providerUserTransformer;
    @Autowired
    private BranchTransformer branchTransformer;
    @Autowired
    private CategoryTransformer categoryTransformer;
    @Autowired
    private DeliveryAreaTransformer deliveryAreaTransformer;

    @Override
    public ProviderBean findProviderById(Integer id) {
        ProviderEntity entity = providerRepo.findById(id);
        return providerTransformer.fromEntityToBean(entity, LANG_EN);
    }

    @Override
    public ProviderBean findProviderWithDetailsById(Integer id) {
        ProviderEntity entity = providerRepo.findById(id);
        return providerTransformer.fromEntityToBeanWithDetails(entity, LANG_EN);
    }

    @Override
    public List<ProviderBean> findProviderList() {
        List<ProviderBean> providerBeanList = new ArrayList();
        List<ProviderEntity> list = providerRepo.findList();
        list.forEach(entity -> providerBeanList.add(providerTransformer.fromEntityToBeanWithDetails(entity, LANG_EN)));
        return providerBeanList;
    }

    @Override
    public ProviderBean addProvider(ProviderBean bean) {
        ProviderEntity addedProviderEntity = providerRepo.add(providerTransformer.fromBeanToEntity(bean));
        return providerTransformer.fromEntityToBean(addedProviderEntity, LANG_EN);
    }

    @Override
    public ProviderBean updateProvider(ProviderBean bean) {
        ProviderEntity addedProviderEntity = providerRepo.update(providerTransformer.fromBeanToEntity(bean));
        return providerTransformer.fromEntityToBean(addedProviderEntity, LANG_EN);
    }

    @Override
    public void removeProvider(Integer id) {
        providerRepo.remove(id);
    }

    @Override
    public ProviderUsersBean findProviderUserById(Integer id) {
        ProviderUserEntity userEntity = providerUserRepo.findById(id);
        return providerUserTransformer.fromEntityToBean(userEntity, LANG_EN);
    }

    @Override
    public List<ProviderUsersBean> findProviderUserList() {
        List<ProviderUsersBean> beanList = new ArrayList();
        List<ProviderUserEntity> list = providerUserRepo.findList();
        list.forEach(entity -> beanList.add(providerUserTransformer.fromEntityToBean(entity, LANG_EN)));
        return beanList;
    }

    @Override
    public List<ProviderUsersBean> findProviderUserListByProviderId(Integer id) {
        List<ProviderUsersBean> beanList = new ArrayList();
        List<ProviderUserEntity> list = providerUserRepo.findProviderUserListByProviderId(id);
        list.forEach(entity -> beanList.add(providerUserTransformer.fromEntityToBean(entity, LANG_EN)));
        return beanList;
    }

    @Override
    public List<ProviderUsersBean> findProviderUserListByBranchId(Integer id) {
        List<ProviderUsersBean> beanList = new ArrayList();
        List<ProviderUserEntity> list = providerUserRepo.findProviderUserListByBranchId(id);
        list.forEach(entity -> beanList.add(providerUserTransformer.fromEntityToBean(entity, LANG_EN)));
        return beanList;
    }

    @Override
    public ProviderUsersBean addProviderUser(ProviderUsersBean provider) {
        ProviderUserEntity entity = providerUserRepo.add(providerUserTransformer.fromBeanToEntity(provider));
        return providerUserTransformer.fromEntityToBean(entity, LANG_EN);
    }

    @Override
    public ProviderUsersBean updateProviderUser(ProviderUsersBean provider) {
        ProviderUserEntity entity = providerUserRepo.update(providerUserTransformer.fromBeanToEntity(provider));
        return providerUserTransformer.fromEntityToBean(entity, LANG_EN);
    }

    @Override
    public void removeProviderUser(Integer id) {
        providerUserRepo.remove(id);
    }

    @Override
    public BranchBean findBranchById(Integer id) {
        return branchTransformer.fromEntityToBean(branchRepo.findById(id), LANG_EN);
    }

    @Override
    public BranchBean findBranchWithDetailsById(Integer id) {
        return branchTransformer.fromEntityToBeanWithDetails(branchRepo.findById(id), LANG_EN);
    }

    @Override
    public List<BranchBean> findBranchList() {
        List<BranchBean> beanslist = new ArrayList();
        branchRepo.findList().forEach(entity -> beanslist.add(branchTransformer.fromEntityToBean(entity, LANG_EN)));
        return beanslist;
    }

    @Override
    public List<BranchBean> findBranchListByProviderId(Integer id) {
        List<BranchBean> beanslist = new ArrayList();
        branchRepo.findBranchListByProviderId(id).forEach(entity -> beanslist.add(branchTransformer.fromEntityToBean(entity, LANG_EN)));
        return beanslist;
    }

    @Override
    public List<BranchBean> findBranchListByAreaId(Integer id) {
        List<BranchBean> beanslist = new ArrayList();
        branchRepo.findBranchListByAreaId(id).forEach(entity -> beanslist.add(branchTransformer.fromEntityToBeanWithDetails(entity, LANG_EN)));
        return beanslist;
    }

    @Override
    public BranchBean addBranch(BranchBean bean) {
        BranchEntity entity = branchTransformer.fromBeanToEntity(bean);
        BranchEntity addedBranchEntity = branchRepo.add(entity);
        return branchTransformer.fromEntityToBean(addedBranchEntity, LANG_EN);
    }

    @Override
    public BranchBean updateBranch(BranchBean bean) {
        BranchEntity entity = branchTransformer.fromBeanToEntity(bean);
        BranchEntity addedBranchEntity = branchRepo.add(entity);
        return branchTransformer.fromEntityToBean(addedBranchEntity, LANG_EN);
    }

    @Override
    public void removeBranch(Integer id) {
        branchRepo.remove(id);
    }

    @Override
    public CategoryBean findCategoryById(Integer id) {
        return categoryTransformer.fromEntityToBean(categoryRepo.findById(id), LANG_EN);
    }

    @Override
    public CategoryBean findCategoryWithDetailsById(Integer id) {
        return categoryTransformer.fromEntityToBeanWithproducts(categoryRepo.findById(id), LANG_EN);
    }

    @Override
    public List<CategoryBean> findCategoryList() {
        List<CategoryBean> beanList = new ArrayList();
        categoryRepo.findList().forEach(entity -> beanList.add(categoryTransformer.fromEntityToBean(entity, LANG_EN)));
        return beanList;
    }

    @Override
    public List<CategoryBean> findCategoryListByProviderId(Integer id) {
        List<CategoryBean> beanList = new ArrayList();
        categoryRepo.findCategoryListByProviderId(id).forEach(entity -> beanList.add(categoryTransformer.fromEntityToBean(entity, LANG_EN)));
        return beanList;
    }

    @Override
    public CategoryBean addCategory(CategoryBean bean) {

        CategoryEntity entity = categoryRepo.add(categoryTransformer.fromBeanToEntity(bean));
        return categoryTransformer.fromEntityToBean(entity, LANG_EN);
    }

    @Override
    public CategoryBean updateCategory(CategoryBean bean) {
        CategoryEntity entity = categoryRepo.update(categoryTransformer.fromBeanToEntity(bean));
        return categoryTransformer.fromEntityToBean(entity, LANG_EN);
    }

    @Override
    public void removeCategory(Integer id) {
        categoryRepo.remove(id);
    }

    @Override
    public DeliveryAreaBean findDeliveryAreaById(Integer id) {
        return deliveryAreaTransformer.fromEntityToBean(deliveryAreaRepo.findById(id), LANG_EN);
    }

    @Override
    public List<DeliveryAreaBean> findDeliveryAreaList() {
        List<DeliveryAreaBean> beanList = new ArrayList();
        deliveryAreaRepo.findList().forEach(entity -> beanList.add(deliveryAreaTransformer.fromEntityToBean(entity, LANG_EN)));
        return beanList;
    }

    @Override
    public List<DeliveryAreaBean> findDeliveryAreaListByProviderId(Integer id) {
        List<DeliveryAreaBean> beanList = new ArrayList();
        deliveryAreaRepo.findDeliveryAreaListByProviderId(id).forEach(entity -> beanList.add(deliveryAreaTransformer.fromEntityToBean(entity, LANG_EN)));
        return beanList;
    }

    @Override
    public DeliveryAreaBean addDeliveryArea(DeliveryAreaBean bean) {
        DeliveryAreaEntity entity = deliveryAreaRepo.add(deliveryAreaTransformer.fromBeanToEntity(bean));
        return deliveryAreaTransformer.fromEntityToBean(entity, LANG_EN);
    }

    @Override
    public DeliveryAreaBean updateDeliveryArea(DeliveryAreaBean bean) {
        DeliveryAreaEntity entity = deliveryAreaRepo.update(deliveryAreaTransformer.fromBeanToEntity(bean));
        return deliveryAreaTransformer.fromEntityToBean(entity, LANG_EN);
    }

    @Override
    public void removeDeliveryArea(Integer id) {
        deliveryAreaRepo.remove(id);
    }

    @Override
    public List<DeliveryAreaBean> findDeliveryAreaListByBranchId(Integer id) {
        List<DeliveryAreaBean> beanList = new ArrayList();
        deliveryAreaRepo.findDeliveryAreaListByBranchId(id).forEach(entity -> beanList.add(deliveryAreaTransformer.fromEntityToBean(entity, LANG_EN)));
        return beanList;
    }

}
