package net.web.app.senior.controllers;

import java.util.List;
import net.web.app.senior.beans.AreaBean;
import net.web.app.senior.beans.CityBean;
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
@RequestMapping("Lookups")
public class LookupsAdminManager {

    @Autowired
    SeniorBLGateWay gateWay;

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

    @PutMapping("updateCity")
    public CityBean updateCity(@RequestBody CityBean bean) {
        return gateWay.updateCity(bean);
    }

    @PostMapping("addCityList")
    public List<CityBean> addCityList(@RequestBody List<CityBean> list) {
        return gateWay.addCityList(list);
    }

    @DeleteMapping("removeCity")
    public void removeCity(@RequestParam Integer id) {
        gateWay.removeCity(id);
    }

    @DeleteMapping("removeCityList")
    public void removeCityList() {
        gateWay.removeCityList();
    }

    @GetMapping("findAreaList")
    public List<AreaBean> findAreaList() {
        return gateWay.findAreaList();
    }

    @GetMapping("findAreaListByCityId")
    public List<AreaBean> findAreaListByCityId(@RequestParam Integer id) {
        return gateWay.findAreaListByCityId(id);
    }

    @GetMapping("findAreaById")
    public AreaBean findAreaById(@RequestParam Integer id) {
        return gateWay.findAreaById(id);
    }

    @PostMapping("addArea")
    public AreaBean addArea(@RequestBody AreaBean bean) {
        return gateWay.addArea(bean);
    }

    @PutMapping("updateArea")
    public AreaBean updateArea(@RequestBody AreaBean bean) {
        return gateWay.updateArea(bean);
    }

    @PostMapping("addAreaList")
    public List<AreaBean> addAreaList(@RequestBody List<AreaBean> list) {
        return gateWay.addAreaList(list);
    }

    @DeleteMapping("removeArea")
    public void removeArea(@RequestParam Integer id) {
        gateWay.removeArea(id);
    }

    @DeleteMapping("removeAreaList")
    public void removeAreaList() {
        gateWay.removeAreaList();
    }
}
