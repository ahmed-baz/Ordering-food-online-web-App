package net.web.app.senior.bll.manager;

import java.util.List;
import net.web.app.senior.beans.AreaBean;
import net.web.app.senior.beans.CityBean;

public interface LookupsManager {

    public CityBean addCity(CityBean cityBean);

    public List<CityBean> addCityList(List<CityBean> list);

    public CityBean updateCity(CityBean cityBean);

    public void removeCity(Integer id);

    public void removeCityList();

    public CityBean findCityById(Integer id);

    public List<CityBean> findCityList();

    public List<CityBean> searchCityByName(String keyword);

    public AreaBean addArea(AreaBean areaBean);

    public List<AreaBean> addAreaList(List<AreaBean> areaList);

    public AreaBean updateArea(AreaBean areaBean);

    public AreaBean findAreaById(Integer id);

    public List<AreaBean> findAreaList();

    public List<AreaBean> findAreaListByCityId(Integer id);

    public void removeArea(Integer id);

    public void removeAreaList();

}
