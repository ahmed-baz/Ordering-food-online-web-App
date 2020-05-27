package net.web.app.senior.web.controller;

import java.util.List;
import net.web.app.senior.beans.CityBean;
import net.web.app.senior.bll.SeniorBLGateWay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/City/")
public class CityController {

    @Autowired
    private SeniorBLGateWay gateWay;

    @RequestMapping(value = "findCityList", method = RequestMethod.GET)
    public ModelAndView findCityList() {
        List<CityBean> cityList = gateWay.findCityList();
        ModelAndView model = new ModelAndView();
        model.setViewName("City");
        model.addObject("cityList", cityList);
        return model;
    }

    // <editor-fold defaultstate="collapsed" desc="geters and setters">
    public void setGateWay(SeniorBLGateWay gateWay) {
        this.gateWay = gateWay;
    }
    // </editor-fold>
}
