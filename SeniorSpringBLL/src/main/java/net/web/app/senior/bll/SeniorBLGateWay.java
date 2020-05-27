package net.web.app.senior.bll;

import java.util.List;
import net.web.app.senior.beans.AreaBean;
import net.web.app.senior.beans.BranchBean;
import net.web.app.senior.beans.CityBean;
import net.web.app.senior.bll.manager.LookupsManager;
import net.web.app.senior.bll.manager.OrderManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SeniorBLGateWay {

    @Autowired
    private LookupsManager lookupsManager;

    @Autowired
    private OrderManager orderManager;

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

    public List<CityBean> cityListSearch(String keyword) {
        return lookupsManager.cityListSearch(keyword);
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

}
