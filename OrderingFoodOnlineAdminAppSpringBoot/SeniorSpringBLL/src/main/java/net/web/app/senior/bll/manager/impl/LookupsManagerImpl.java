package net.web.app.senior.bll.manager.impl;

import java.util.ArrayList;
import java.util.List;
import net.web.app.senior.beans.AreaBean;
import net.web.app.senior.beans.CityBean;
import net.web.app.senior.bll.manager.LookupsManager;
import net.web.app.senior.bll.transformer.AreaTransformer;
import net.web.app.senior.bll.transformer.CityTransformer;
import net.web.app.senior.constant.SeniorConstant;
import net.web.app.senior.dal.entity.AreaEntity;
import net.web.app.senior.dal.entity.CityEntity;
import net.web.app.senior.dal.repo.AreaRepo;
import net.web.app.senior.dal.repo.CityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class LookupsManagerImpl implements LookupsManager, SeniorConstant {

    @Autowired
    private CityTransformer cityTransformer;
    @Autowired
    private AreaTransformer areaTransformer;
    @Autowired
    private AreaRepo areaRepo;
    @Autowired
    private CityRepo cityRepo;

    public LookupsManagerImpl() {
    }

    @Override
    public List<CityBean> findCityList() {
        List<CityBean> cityBeanList = new ArrayList<>();
        List<CityEntity> cityEntityList = cityRepo.findList();
        for (CityEntity cityEntity : cityEntityList) {
            CityBean fromEntityToBean = cityTransformer.fromEntityToBeanWithAreas(cityEntity, LANG_EN);
            cityBeanList.add(fromEntityToBean);
        }
        return cityBeanList;
    }

    @Override
    public CityBean findCityById(Integer id) {
        CityEntity cityEntity = cityRepo.findById(id);
        CityBean cityBean = cityTransformer.fromEntityToBeanWithAreas(cityEntity, LANG_EN);
        return cityBean;
    }

    @Override
    public CityBean addCity(CityBean cityBean) {
        CityEntity city = cityTransformer.fromBeanToEntityWithArea(cityBean);
        CityEntity addedCity = cityRepo.add(city);
        CityBean resultCityBean = cityTransformer.fromEntityToBeanWithAreas(addedCity, LANG_EN);
        return resultCityBean;
    }

    @Override
    public List<CityBean> addCityList(List<CityBean> list) {
        List<CityEntity> listEntity = new ArrayList<>();
        list.forEach(cityBean -> listEntity.add(cityTransformer.fromBeanToEntityWithArea(cityBean)));
        List<CityEntity> addedCityList = cityRepo.addList(listEntity);
        List<CityBean> resultCityBean = new ArrayList<>();
        addedCityList.forEach(cityEntity -> resultCityBean.add(cityTransformer.fromEntityToBeanWithAreas(cityEntity, LANG_EN)));
        return resultCityBean;
    }

    @Override
    public CityBean updateCity(CityBean cityBean) {
        CityEntity cityEntity = cityTransformer.fromBeanToEntity(cityBean);
        CityEntity newCityEntity = cityRepo.update(cityEntity);
        CityBean newCityBean = cityTransformer.fromEntityToBean(newCityEntity, LANG_EN);
        return newCityBean;
    }

    @Override
    public void removeCity(Integer id) {
        cityRepo.remove(id);
    }

    @Override
    public void removeCityList() {
        cityRepo.removeAllList();
    }

    @Override
    public List<CityBean> searchCityByName(String keyword) {
        List<CityBean> cityBeanList = new ArrayList();
        cityRepo.searchByName(keyword).forEach(entity -> cityBeanList.add(cityTransformer.fromEntityToBeanWithAreas(entity, LANG_EN)));
        return cityBeanList;
    }

    @Override
    public AreaBean updateArea(AreaBean areaBean) {
        AreaEntity areaEntity = areaTransformer.fromBeanToEntity(areaBean);
        AreaEntity addedAreaEntity = areaRepo.update(areaEntity);
        AreaBean resultAreaBean = areaTransformer.fromEntityToBeanWithCity(addedAreaEntity, LANG_EN);
        return resultAreaBean;
    }

    @Override
    public AreaBean findAreaById(Integer id) {
        AreaEntity areaEntity = areaRepo.findById(id);
        AreaBean areaBean = areaTransformer.fromEntityToBeanWithCity(areaEntity, LANG_EN);
        return areaBean;
    }

    @Override
    public AreaBean addArea(AreaBean areaBean) {
        AreaEntity areaEntity = areaTransformer.fromBeanToEntity(areaBean);
        AreaEntity addedAreaEntity = areaRepo.add(areaEntity);
        AreaBean resultAreaBean = areaTransformer.fromEntityToBean(addedAreaEntity, LANG_EN);
        return resultAreaBean;
    }

    @Override
    public List<AreaBean> addAreaList(List<AreaBean> areaList) {
        List<AreaEntity> areaEntityList = new ArrayList();
        List<AreaBean> areaBeanList = new ArrayList();
        areaList.forEach(bean -> areaEntityList.add(areaTransformer.fromBeanToEntity(bean)));
        areaRepo.addList(areaEntityList).forEach(entity -> areaBeanList.add(areaTransformer.fromEntityToBeanWithCity(entity, LANG_AR)));
        return areaList;
    }

    @Override
    public List<AreaBean> findAreaList() {
        List<AreaBean> areaBeanList = new ArrayList();
        areaRepo.findList().forEach(entity -> areaBeanList.add(areaTransformer.fromEntityToBeanWithCity(entity, LANG_AR)));
        return areaBeanList;
    }

    @Override
    public void removeArea(Integer id) {
        areaRepo.remove(id);
    }

    @Override
    public void removeAreaList() {
        areaRepo.removeAllList();
    }

    // <editor-fold defaultstate="collapsed" desc="geters and setters">
    public void setCityTransformer(CityTransformer cityTransformer) {
        this.cityTransformer = cityTransformer;
    }

    public void setAreaTransformer(AreaTransformer areaTransformer) {
        this.areaTransformer = areaTransformer;
    }

    public void setAreaRepo(AreaRepo areaRepo) {
        this.areaRepo = areaRepo;
    }

    public void setCityRepo(CityRepo cityRepo) {
        this.cityRepo = cityRepo;
    }
    // </editor-fold>

    @Override
    public List<AreaBean> findAreaListByCityId(Integer id) {
        List<AreaBean> areaBeanList = new ArrayList();
        areaRepo.findAreaListByCityId(id).forEach(entity -> areaBeanList.add(areaTransformer.fromEntityToBeanWithCity(entity, LANG_AR)));
        return areaBeanList;
    }

}
