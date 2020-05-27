package net.web.app.senior.dal.repo;

import net.web.app.senior.dal.entity.AdminUserEntity;

public interface AdminUserRepo extends CommonRepo<AdminUserEntity> {

    public Boolean checkLogin(String userName, String password);
}
