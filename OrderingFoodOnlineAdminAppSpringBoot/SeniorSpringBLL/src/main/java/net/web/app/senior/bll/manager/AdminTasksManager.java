
package net.web.app.senior.bll.manager;

import java.util.List;
import net.web.app.senior.beans.BranchBean;
import net.web.app.senior.beans.ProviderBean;

public interface AdminTasksManager {

    public BranchBean addBranch(BranchBean branchBean);

    public BranchBean updateBranch(BranchBean branchBean);

    public void removeBranch(Integer id);

    public BranchBean findBranchById(Integer id);

    public List<BranchBean> findBranchList();

    public ProviderBean addProvider(ProviderBean providerBean);

    public ProviderBean updateProvider(ProviderBean providerBean);

    public void removeProvider(Integer id);

    public ProviderBean findProviderById(Integer id);

    public List<ProviderBean> findProviderList();

}
