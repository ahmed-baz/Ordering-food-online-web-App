package net.web.app.senior.controllers;

import net.web.app.senior.bll.SeniorBLGateWay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("Menus")
public class MenusProviderManager {

    @Autowired
    SeniorBLGateWay gateWay;

    public void setGateWay(SeniorBLGateWay gateWay) {
        this.gateWay = gateWay;
    }
}
