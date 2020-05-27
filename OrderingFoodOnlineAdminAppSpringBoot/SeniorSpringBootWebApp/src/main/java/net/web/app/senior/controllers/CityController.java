package net.web.app.senior.controllers;

import java.util.List;
import net.web.app.senior.beans.CityBean;
import net.web.app.senior.bll.SeniorBLGateWay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("City")
public class CityController {

    @Autowired
    SeniorBLGateWay gateWay;

    public void setGateWay(SeniorBLGateWay gateWay) {
        this.gateWay = gateWay;
    }

    @GetMapping("findCityList")
    public List<CityBean> findCityList() {
        return gateWay.findCityList();
    }

    @GetMapping("findCityById")
    public CityBean findCityById(@RequestParam String id) {
        return gateWay.findCityById(Integer.parseInt(id));
    }

    @PostMapping("addCity")
    public CityBean addCity(@RequestBody CityBean bean) {
        return gateWay.addCity(bean);
    }
}
