package net.web.app.senior.bll.manager;

import java.util.List;
import net.web.app.senior.beans.ProviderBean;
import net.web.app.senior.beans.BranchBean;
import net.web.app.senior.beans.CategoryBean;
import net.web.app.senior.beans.DeliveryAreaBean;
import net.web.app.senior.beans.ProviderUsersBean;

public interface ProviderManager {

    public ProviderBean findProviderById(Integer id);

    public ProviderBean findProviderWithDetailsById(Integer id);

    public List<ProviderBean> findProviderList();

    public ProviderBean addProvider(ProviderBean provider);

    public ProviderBean updateProvider(ProviderBean provider);

    public void removeProvider(Integer id);

    public ProviderUsersBean findProviderUserById(Integer id);

    public List<ProviderUsersBean> findProviderUserList();

    public List<ProviderUsersBean> findProviderUserListByProviderId(Integer id);

    public List<ProviderUsersBean> findProviderUserListByBranchId(Integer id);

    public ProviderUsersBean addProviderUser(ProviderUsersBean providerUser);

    public ProviderUsersBean updateProviderUser(ProviderUsersBean providerUser);

    public void removeProviderUser(Integer id);

    public BranchBean findBranchById(Integer id);

    public BranchBean findBranchWithDetailsById(Integer id);

    public List<BranchBean> findBranchList();

    public List<BranchBean> findBranchListByProviderId(Integer id);

    public List<BranchBean> findBranchListByAreaId(Integer id);

    public BranchBean addBranch(BranchBean branch);

    public BranchBean updateBranch(BranchBean branch);

    public void removeBranch(Integer id);

    public CategoryBean findCategoryById(Integer id);

    public CategoryBean findCategoryWithDetailsById(Integer id);

    public List<CategoryBean> findCategoryList();

    public List<CategoryBean> findCategoryListByProviderId(Integer id);

    public CategoryBean addCategory(CategoryBean category);

    public CategoryBean updateCategory(CategoryBean category);

    public void removeCategory(Integer id);

    public DeliveryAreaBean findDeliveryAreaById(Integer id);

    public List<DeliveryAreaBean> findDeliveryAreaList();

    public List<DeliveryAreaBean> findDeliveryAreaListByBranchId(Integer id);

    public List<DeliveryAreaBean> findDeliveryAreaListByProviderId(Integer id);

    public DeliveryAreaBean addDeliveryArea(DeliveryAreaBean bean);

    public DeliveryAreaBean updateDeliveryArea(DeliveryAreaBean bean);

    public void removeDeliveryArea(Integer id);

}
