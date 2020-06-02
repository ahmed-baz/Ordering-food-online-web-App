package net.web.app.senior.controllers;

import java.util.List;
import net.web.app.senior.beans.ProviderBean;
import net.web.app.senior.beans.ProviderUsersBean;
import net.web.app.senior.beans.BranchBean;
import net.web.app.senior.beans.CategoryBean;
import net.web.app.senior.beans.DeliveryAreaBean;
import net.web.app.senior.bll.SeniorBLGateWay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("Provider")
public class ProviderManager {

    @Autowired
    SeniorBLGateWay gateWay;

    @GetMapping("findProviderList")
    public List<ProviderBean> findProviderList() {
        return gateWay.findProviderList();
    }

    @GetMapping("findProviderById")
    public ProviderBean findProviderById(@RequestParam Integer id) {
        return gateWay.findProviderById(id);
    }

    @GetMapping("findProviderWithDetailsById")
    public ProviderBean findProviderWithDetailsById(@RequestParam Integer id) {
        return gateWay.findProviderWithDetailsById(id);
    }

    @PostMapping("addProvider")
    public ProviderBean addProvider(@RequestBody ProviderBean bean) {
        return gateWay.addProvider(bean);
    }

    @PutMapping("updateProvider")
    public ProviderBean updateProvider(@RequestBody ProviderBean bean) {
        return gateWay.updateProvider(bean);
    }

    @DeleteMapping("removeProvider")
    public void removeProvider(@RequestParam Integer id) {
        gateWay.removeProvider(id);
    }

    @GetMapping("findCategoryList")
    public List<CategoryBean> findCategoryList() {
        return gateWay.findCategoryList();
    }

    @GetMapping("findCategoryListByProviderId")
    public List<CategoryBean> findCategoryListByProviderId(@RequestParam Integer id) {
        return gateWay.findCategoryListByProviderId(id);
    }

    @GetMapping("findCategoryById")
    public CategoryBean findCategoryById(@RequestParam Integer id) {
        return gateWay.findCategoryById(id);
    }

    @GetMapping("findCategoryWithDetailsById")
    public CategoryBean findCategoryWithDetailsById(@RequestParam Integer id) {
        return gateWay.findCategoryWithDetailsById(id);
    }

    @PostMapping("addCategory")
    public CategoryBean addCategory(@RequestBody CategoryBean bean) {
        return gateWay.addCategory(bean);
    }

    @PutMapping("updateCategory")
    public CategoryBean updateCategory(@RequestBody CategoryBean bean) {
        return gateWay.updateCategory(bean);
    }

    @DeleteMapping("removeCategory")
    public void removeCategory(@RequestParam Integer id) {
        gateWay.removeCategory(id);
    }

    @GetMapping("findBranchList")
    public List<BranchBean> findBranchList() {
        return gateWay.findBranchList();
    }

    @GetMapping("findBranchListByProviderId")
    public List<BranchBean> findBranchListByProviderId(@RequestParam Integer id) {
        return gateWay.findBranchListByProviderId(id);
    }

    @GetMapping("findBranchById")
    public BranchBean findBranchById(@RequestParam Integer id) {
        return gateWay.findBranchById(id);
    }

    @GetMapping("findBranchWithDetailsById")
    public BranchBean findBranchWithDetailsById(@RequestParam Integer id) {
        return gateWay.findBranchWithDetailsById(id);
    }

    @PostMapping("addBranch")
    public BranchBean addBranch(@RequestBody BranchBean bean) {
        return gateWay.addBranch(bean);
    }

    @PutMapping("updateBranch")
    public BranchBean updateBranch(@RequestBody BranchBean bean) {
        return gateWay.updateBranch(bean);
    }

    @DeleteMapping("removeBranch")
    public void removeBranch(@RequestParam Integer id) {
        gateWay.removeBranch(id);
    }

    @GetMapping("findProviderUserList")
    public List<ProviderUsersBean> findProviderUserList() {
        return gateWay.findProviderUserList();
    }

    @GetMapping("findProviderUserListByProviderId")
    public List<ProviderUsersBean> findProviderUserListByProviderId(@RequestParam Integer id) {
        return gateWay.findProviderUserListByProviderId(id);
    }

    @GetMapping("findProviderUserListByBranchId")
    public List<ProviderUsersBean> findProviderUserListByBranchId(@RequestParam Integer id) {
        return gateWay.findProviderUserListByBranchId(id);
    }

    @GetMapping("findProviderUserById")
    public ProviderUsersBean findProviderUserById(@RequestParam Integer id) {
        return gateWay.findProviderUserById(id);
    }

    @PostMapping("addProviderUser")
    public ProviderUsersBean addProviderUser(@RequestBody ProviderUsersBean bean) {
        return gateWay.addProviderUser(bean);
    }

    @PutMapping("updateProviderUser")
    public ProviderUsersBean updateProviderUser(@RequestBody ProviderUsersBean bean) {
        return gateWay.updateProviderUser(bean);
    }

    @DeleteMapping("removeProviderUser")
    public void removeProviderUser(@RequestParam Integer id) {
        gateWay.removeProviderUser(id);
    }

    @GetMapping("findDeliveryAreaById")
    public DeliveryAreaBean findDeliveryAreaById(@RequestParam Integer id) {
        return gateWay.findDeliveryAreaById(id);
    }

    @GetMapping("findDeliveryAreaList")
    public List<DeliveryAreaBean> findDeliveryAreaList() {
        return gateWay.findDeliveryAreaList();
    }

    @GetMapping("findDeliveryAreaListByBranchId")
    public List<DeliveryAreaBean> findDeliveryAreaListByBranchId(@RequestParam Integer id) {
        return gateWay.findDeliveryAreaListByBranchId(id);
    }

    @GetMapping("findDeliveryAreaListByProviderId")
    public List<DeliveryAreaBean> findDeliveryAreaListByProviderId(@RequestParam Integer id) {
        return gateWay.findDeliveryAreaListByProviderId(id);
    }

    @PostMapping("addDeliveryArea")
    public DeliveryAreaBean addDeliveryArea(@RequestBody DeliveryAreaBean bean) {
        return gateWay.addDeliveryArea(bean);
    }

    @PutMapping("updateDeliveryArea")
    public DeliveryAreaBean updateDeliveryArea(@RequestBody DeliveryAreaBean bean) {
        return gateWay.updateDeliveryArea(bean);
    }

    @DeleteMapping("removeDeliveryArea")
    public void removeDeliveryArea(@RequestParam Integer id) {
        gateWay.removeDeliveryArea(id);
    }
}
