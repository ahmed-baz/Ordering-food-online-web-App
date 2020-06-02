package net.web.app.senior.controllers;

import java.util.List;
import net.web.app.senior.bll.SeniorBLGateWay;
import net.web.app.senior.beans.AdminUserBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class AuthenticationManager {

    @Autowired
    SeniorBLGateWay gateWay;

    @GetMapping("checkLogin")
    public Boolean checkLogin(@RequestBody AdminUserBean user) {
        return gateWay.checkLogin(user);
    }

    @GetMapping("findAdminUserList")
    public List<AdminUserBean> findAdminUserList() {
        return gateWay.findAdminUserList();
    }

    @GetMapping("findAdminUserById")
    public AdminUserBean findAdminUserById(@RequestParam Integer id) {
        return gateWay.findAdminUserById(id);
    }

    @PostMapping("addNewAdminUser")
    public AdminUserBean findAdminUserById(@RequestBody AdminUserBean user) {
        return gateWay.addNewAdminUser(user);
    }

    @PutMapping("updateAdminUser")
    public AdminUserBean updateAdminUser(@RequestBody AdminUserBean user) {
        return gateWay.updateAdminUser(user);
    }

    @DeleteMapping("removeAdminUser")
    public void removeAdminUser(@RequestParam Integer id) {
        gateWay.removeAdminUser(id);
    }
}
