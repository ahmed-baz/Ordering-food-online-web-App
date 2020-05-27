package net.web.app.senior.controllers;

import net.web.app.senior.bll.SeniorBLGateWay;
import net.web.app.senior.utils.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class AuthenticationManager {

    @Autowired
    SeniorBLGateWay gateWay;

    @GetMapping("checkLogin")
    public Boolean checkLogin(@RequestBody User user) {
        return gateWay.checkLogin(user.getUserName(), user.getPassword());
    }
}
