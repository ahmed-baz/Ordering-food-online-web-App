package net.web.app.senior.bll.manager;

import java.util.List;
import net.web.app.senior.beans.AdminUserBean;

public interface AuthenticationManager {

    public Boolean checkLogin(AdminUserBean user);

    public AdminUserBean findAdminUserById(Integer id);

    public List<AdminUserBean> findAdminUserList();

    public AdminUserBean addNewAdminUser(AdminUserBean user);

    public AdminUserBean updateAdminUser(AdminUserBean user);

    public void removeAdminUser(Integer id);

}
