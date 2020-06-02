package net.web.app.senior.bll.manager.impl;

import java.util.ArrayList;
import java.util.List;
import net.web.app.senior.beans.AdminUserBean;
import net.web.app.senior.bll.manager.AuthenticationManager;
import net.web.app.senior.bll.transformer.AdminUserTransformer;
import net.web.app.senior.constant.SeniorConstant;
import net.web.app.senior.dal.entity.AdminUserEntity;
import net.web.app.senior.dal.repo.AdminUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AuthenticationManagerImpl implements AuthenticationManager, SeniorConstant {
    
    @Autowired
    private AdminUserRepo adminUserRepo;
    @Autowired
    private AdminUserTransformer adminUserTransformer;
    
    @Override
    public Boolean checkLogin(AdminUserBean user) {
        return adminUserRepo.checkLogin(user.getUsername(), user.getPassword());
    }
    
    @Override
    public AdminUserBean findAdminUserById(Integer id) {
        return adminUserTransformer.fromEntityToBean(adminUserRepo.findById(id), LANG_EN);
    }
    
    @Override
    public List<AdminUserBean> findAdminUserList() {
        List<AdminUserBean> list = new ArrayList();
        adminUserRepo.findList().forEach(user -> list.add(adminUserTransformer.fromEntityToBean(user, LANG_EN)));
        return list;
    }
    
    @Override
    public AdminUserBean addNewAdminUser(AdminUserBean user) {
        AdminUserEntity entity = adminUserRepo.add(adminUserTransformer.fromBeanToEntity(user));
        return adminUserTransformer.fromEntityToBean(entity, LANG_EN);
    }
    
    @Override
    public AdminUserBean updateAdminUser(AdminUserBean user) {
        AdminUserEntity entity = adminUserRepo.update(adminUserTransformer.fromBeanToEntity(user));
        return adminUserTransformer.fromEntityToBean(entity, LANG_EN);
    }
    
    @Override
    public void removeAdminUser(Integer id) {
        adminUserRepo.remove(id);
    }
}
