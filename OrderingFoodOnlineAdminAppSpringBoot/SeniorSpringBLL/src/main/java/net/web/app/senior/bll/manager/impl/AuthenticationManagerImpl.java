package net.web.app.senior.bll.manager.impl;

import net.web.app.senior.bll.manager.AuthenticationManager;
import net.web.app.senior.dal.repo.AdminUserRepo;
import net.web.app.senior.dal.repo.impl.AdminUserRepoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AuthenticationManagerImpl implements AuthenticationManager {

    @Autowired
    private AdminUserRepo adminUserRepo;

    @Override
    public Boolean checkLogin(String userName, String password) {
        return adminUserRepo.checkLogin(userName, password);
    }

    public void setAdminUserRepo(AdminUserRepoImpl adminUserRepo) {
        this.adminUserRepo = adminUserRepo;
    }

}
