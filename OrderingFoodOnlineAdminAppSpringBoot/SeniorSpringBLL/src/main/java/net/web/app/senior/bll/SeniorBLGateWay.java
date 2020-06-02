package net.web.app.senior.bll;

import java.util.List;
import net.web.app.senior.beans.AdminUserBean;
import net.web.app.senior.beans.AreaBean;
import net.web.app.senior.beans.BranchBean;
import net.web.app.senior.beans.CategoryBean;
import net.web.app.senior.beans.CityBean;
import net.web.app.senior.beans.DeliveryAreaBean;
import net.web.app.senior.beans.ProviderBean;
import net.web.app.senior.beans.ProviderUsersBean;
import net.web.app.senior.bll.manager.AuthenticationManager;
import net.web.app.senior.bll.manager.LookupsManager;
import net.web.app.senior.bll.manager.ProviderManager;
import net.web.app.senior.bll.manager.OrderManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SeniorBLGateWay {

    @Autowired
    private LookupsManager lookupsManager;

    public ProviderBean findProviderWithDetailsById(Integer id) {
        return providerManager.findProviderWithDetailsById(id);
    }

    public BranchBean findBranchWithDetailsById(Integer id) {
        return providerManager.findBranchWithDetailsById(id);
    }

    public CategoryBean findCategoryWithDetailsById(Integer id) {
        return providerManager.findCategoryWithDetailsById(id);
    }

    public List<ProviderUsersBean> findProviderUserListByBranchId(Integer id) {
        return providerManager.findProviderUserListByBranchId(id);
    }

    public AdminUserBean findAdminUserById(Integer id) {
        return authenticationManager.findAdminUserById(id);
    }

    public List<AdminUserBean> findAdminUserList() {
        return authenticationManager.findAdminUserList();
    }

    public AdminUserBean addNewAdminUser(AdminUserBean user) {
        return authenticationManager.addNewAdminUser(user);
    }

    public AdminUserBean updateAdminUser(AdminUserBean user) {
        return authenticationManager.updateAdminUser(user);
    }

    public AreaBean findAreaWithDetailsById(Integer id) {
        return lookupsManager.findAreaWithDetailsById(id);
    }

    public void removeAdminUser(Integer id) {
        authenticationManager.removeAdminUser(id);
    }

    public Boolean checkLogin(AdminUserBean user) {
        return authenticationManager.checkLogin(user);
    }
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private OrderManager orderManager;
    @Autowired
    private ProviderManager providerManager;

    public ProviderUsersBean findProviderUserById(Integer id) {
        return providerManager.findProviderUserById(id);
    }

    public List<BranchBean> findBranchListByAreaId(Integer id) {
        return providerManager.findBranchListByAreaId(id);
    }

    public DeliveryAreaBean findDeliveryAreaById(Integer id) {
        return providerManager.findDeliveryAreaById(id);
    }

    public List<DeliveryAreaBean> findDeliveryAreaList() {
        return providerManager.findDeliveryAreaList();
    }

    public List<DeliveryAreaBean> findDeliveryAreaListByBranchId(Integer id) {
        return providerManager.findDeliveryAreaListByBranchId(id);
    }

    public List<DeliveryAreaBean> findDeliveryAreaListByProviderId(Integer id) {
        return providerManager.findDeliveryAreaListByProviderId(id);
    }

    public DeliveryAreaBean addDeliveryArea(DeliveryAreaBean bean) {
        return providerManager.addDeliveryArea(bean);
    }

    public CityBean findCityWithDetailsById(Integer id) {
        return lookupsManager.findCityWithDetailsById(id);
    }

    public DeliveryAreaBean updateDeliveryArea(DeliveryAreaBean bean) {
        return providerManager.updateDeliveryArea(bean);
    }

    public void removeDeliveryArea(Integer id) {
        providerManager.removeDeliveryArea(id);
    }

    public List<ProviderUsersBean> findProviderUserList() {
        return providerManager.findProviderUserList();
    }

    public List<ProviderUsersBean> findProviderUserListByProviderId(Integer id) {
        return providerManager.findProviderUserListByProviderId(id);
    }

    public ProviderUsersBean addProviderUser(ProviderUsersBean providerUser) {
        return providerManager.addProviderUser(providerUser);
    }

    public ProviderUsersBean updateProviderUser(ProviderUsersBean providerUser) {
        return providerManager.updateProviderUser(providerUser);
    }

    public void removeProviderUser(Integer id) {
        providerManager.removeProviderUser(id);
    }

    public BranchBean findBranchById(Integer id) {
        return providerManager.findBranchById(id);
    }

    public List<BranchBean> findBranchListByProviderId(Integer id) {
        return providerManager.findBranchListByProviderId(id);
    }

    public BranchBean updateBranch(BranchBean branch) {
        return providerManager.updateBranch(branch);
    }

    public void removeBranch(Integer id) {
        providerManager.removeBranch(id);
    }

    public CategoryBean findCategoryById(Integer id) {
        return providerManager.findCategoryById(id);
    }

    public List<CategoryBean> findCategoryList() {
        return providerManager.findCategoryList();
    }

    public List<CategoryBean> findCategoryListByProviderId(Integer id) {
        return providerManager.findCategoryListByProviderId(id);
    }

    public CategoryBean addCategory(CategoryBean category) {
        return providerManager.addCategory(category);
    }

    public CategoryBean updateCategory(CategoryBean category) {
        return providerManager.updateCategory(category);
    }

    public void removeCategory(Integer id) {
        providerManager.removeCategory(id);
    }

    public List<ProviderBean> findProviderList() {
        return providerManager.findProviderList();
    }

    public ProviderBean addProvider(ProviderBean provider) {
        return providerManager.addProvider(provider);
    }

    public ProviderBean updateProvider(ProviderBean provider) {
        return providerManager.updateProvider(provider);
    }

    public void removeProvider(Integer id) {
        providerManager.removeProvider(id);
    }

    public BranchBean addBranch(BranchBean branch) {
        return providerManager.addBranch(branch);
    }

    public List<AreaBean> findAreaListByCityId(Integer id) {
        return lookupsManager.findAreaListByCityId(id);
    }

    public List<AreaBean> addAreaList(List<AreaBean> areaList) {
        return lookupsManager.addAreaList(areaList);
    }

    public void removeAreaList() {
        lookupsManager.removeAreaList();
    }

    public List<CityBean> addCityList(List<CityBean> list) {
        return lookupsManager.addCityList(list);
    }

    public void removeCityList() {
        lookupsManager.removeCityList();
    }

    public List<CityBean> findCityList() {
        return lookupsManager.findCityList();
    }

    public CityBean addCity(CityBean cityBean) {
        return lookupsManager.addCity(cityBean);
    }

    public CityBean updateCity(CityBean cityBean) {
        return lookupsManager.updateCity(cityBean);
    }

    public void removeCity(Integer id) {
        lookupsManager.removeCity(id);
    }

    public List<CityBean> searchCityByName(String keyword) {
        return lookupsManager.searchCityByName(keyword);
    }

    public AreaBean addArea(AreaBean areaBean) {
        return lookupsManager.addArea(areaBean);
    }

    public AreaBean updateArea(AreaBean areaBean) {
        return lookupsManager.updateArea(areaBean);
    }

    public void removeArea(Integer id) {
        lookupsManager.removeArea(id);
    }

    public AreaBean findAreaById(Integer id) {
        return lookupsManager.findAreaById(id);
    }

    public List<AreaBean> findAreaList() {
        return lookupsManager.findAreaList();
    }

    public CityBean findCityById(Integer id) {
        return lookupsManager.findCityById(id);
    }

    public List<BranchBean> findBranchList() {
        return orderManager.findBranchList();
    }

    public List<BranchBean> searchBranchByName(String name) {
        return orderManager.searchBranchByName(name);
    }

    public ProviderBean findProviderById(Integer id) {
        return providerManager.findProviderById(id);
    }

    // <editor-fold defaultstate="collapsed" desc="geters and setters">
    public void setLookupsManager(LookupsManager lookupsManager) {
        this.lookupsManager = lookupsManager;
    }

    public void setOrderManager(OrderManager orderManager) {
        this.orderManager = orderManager;
    }

    public void setAuthenticationManager(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    public void setProviderManager(ProviderManager providerManager) {
        this.providerManager = providerManager;
    }
    // </editor-fold>

}
