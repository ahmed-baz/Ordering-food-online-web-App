package net.web.app.senior.bll.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import net.web.app.senior.beans.BranchBean;
import net.web.app.senior.beans.OrderBean;
import net.web.app.senior.beans.ProviderBean;
import net.web.app.senior.bll.manager.OrderManager;
import net.web.app.senior.bll.transformer.BranchTransformer;
import net.web.app.senior.bll.transformer.ProviderTransformer;
import static net.web.app.senior.constant.SeniorConstant.LANG_EN;
import net.web.app.senior.dal.entity.BranchEntity;
import net.web.app.senior.dal.entity.ProviderEntity;
import net.web.app.senior.dal.repo.BranchRepo;
import net.web.app.senior.dal.repo.ProviderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderManagerImpl implements OrderManager {

    @Autowired
    private BranchRepo branchRepo;
    @Autowired
    private ProviderRepo providerRepo;
    @Autowired
    private BranchTransformer branchTransformer;
    @Autowired
    private ProviderTransformer providerTransformer;

    public void setBranchRepo(BranchRepo branchRepo) {
        this.branchRepo = branchRepo;
    }

    public void setProviderRepo(ProviderRepo providerRepo) {
        this.providerRepo = providerRepo;
    }

    public void setBranchTransformer(BranchTransformer branchTransformer) {
        this.branchTransformer = branchTransformer;
    }

    public void setProviderTransformer(ProviderTransformer providerTransformer) {
        this.providerTransformer = providerTransformer;
    }

    @Override
    @Transactional
    public OrderBean addOrder(OrderBean orderBean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @Transactional
    public OrderBean updateOrder(OrderBean orderBean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @Transactional
    public OrderBean cancelOrder(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @Transactional
    public List<BranchBean> findBranchList() {
        List<BranchBean> branchBeanList = new ArrayList<>();
        List<BranchEntity> branchEntityList = branchRepo.findList();
        for (BranchEntity iEntity : branchEntityList) {
            BranchBean bean = branchTransformer.fromEntityToBeanWithDeliveryAreas(iEntity, LANG_EN);
            branchBeanList.add(bean);
        }

        return branchBeanList;
    }

    @Override
    @Transactional
    public List<BranchBean> searchBranchByName(String name) {
        List<BranchBean> branchBeanList = new ArrayList<>();
        List<BranchEntity> branchEntityList = branchRepo.searchByName(name);
        for (BranchEntity iEntity : branchEntityList) {
            BranchBean bean = branchTransformer.fromEntityToBeanWithDeliveryAreas(iEntity, LANG_EN);
            branchBeanList.add(bean);
        }

        return branchBeanList;
    }

    @Override
    @Transactional
    public List<ProviderBean> findProviderList() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @Transactional
    public List<ProviderBean> searchProviderByName(String name) {
        List<ProviderBean> branchBeanList = new ArrayList<>();

        List<ProviderEntity> findList = providerRepo.findList();
        for (ProviderEntity providerEntity : findList) {
            ProviderBean providerBean = providerTransformer.fromEntityToBean(providerEntity, LANG_EN);
            branchBeanList.add(providerBean);
        }

        return branchBeanList;
    }

    @Override
    @Transactional
    public Set<BranchBean> findBranchByProviderId(Integer id) {
        ProviderEntity providerEntity = providerRepo.findById(id);
        ProviderBean providerBean = providerTransformer.fromEntityToBean(providerEntity, LANG_EN);
        Set<BranchBean> branchesBean = providerBean.getBranchesBean();

        return branchesBean;
    }

}
