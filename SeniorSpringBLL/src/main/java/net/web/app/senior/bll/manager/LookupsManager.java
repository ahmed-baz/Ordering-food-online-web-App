package net.web.app.senior.bll.manager;

import java.util.List;
import net.web.app.senior.beans.AreaBean;
import net.web.app.senior.beans.CityBean;

public interface LookupsManager {

    public CityBean addCity(CityBean cityBean);

    public CityBean updateCity(CityBean cityBean);

    public void removeCity(Integer id);

    public CityBean findCityById(Integer id);

    public List<CityBean> findCityList();

    public List<CityBean> searchCityByName(String keyword);

    public List<CityBean> cityListSearch(String keyword);

    public AreaBean addArea(AreaBean areaBean);

    public AreaBean updateArea(AreaBean areaBean);

    public void removeArea(Integer id);

    public AreaBean findAreaById(Integer id);

    public List<AreaBean> findAreaList();

}
