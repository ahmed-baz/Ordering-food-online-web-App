package net.web.app.senior.bll.impl;

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
    @Transactional
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
    @Transactional
    public CityBean findCityById(Integer id) {
        CityEntity cityEntity = cityRepo.findById(id);
        CityBean cityBean = cityTransformer.fromEntityToBeanWithAreas(cityEntity, LANG_AR);
        return cityBean;
    }

    @Override
    @Transactional
    public CityBean addCity(CityBean cityBean) {
        CityEntity city = cityTransformer.fromBeanToEntity(cityBean);
        CityEntity addedCity = cityRepo.add(city);
        CityBean resultCityBean = cityTransformer.fromEntityToBean(addedCity, LANG_EN);
        return resultCityBean;
    }

    @Override
    @Transactional
    public CityBean updateCity(CityBean cityBean) {
        CityEntity cityEntity = cityTransformer.fromBeanToEntity(cityBean);
        CityEntity newCityEntity = cityRepo.update(cityEntity);
        CityBean newCityBean = cityTransformer.fromEntityToBean(newCityEntity, LANG_AR);
        return newCityBean;
    }

    @Override
    @Transactional
    public void removeCity(Integer id) {
        cityRepo.remove(id);
    }

    @Override
    @Transactional
    public List<CityBean> cityListSearch(String keyword) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @Transactional
    public List<CityBean> searchCityByName(String keyword) {
        List<CityBean> cityBeanList = new ArrayList<>();
        List<CityEntity> cityEntityList = cityRepo.searchByName(keyword);
        for (CityEntity cityEntity : cityEntityList) {
            CityBean fromEntityToBean = cityTransformer.fromEntityToBean(cityEntity, LANG_EN);
            cityBeanList.add(fromEntityToBean);
        }

        return cityBeanList;
    }

    @Override
    @Transactional
    public AreaBean updateArea(AreaBean areaBean) {
        AreaEntity areaEntity = areaTransformer.fromBeanToEntity(areaBean);
        AreaEntity newAreaEntity = areaRepo.update(areaEntity);
        AreaBean newAreaBean = areaTransformer.fromEntityToBean(newAreaEntity, LANG_AR);
        return newAreaBean;
    }

    @Override
    @Transactional
    public AreaBean findAreaById(Integer id) {
        AreaEntity areaEntity = areaRepo.findById(id);
        AreaBean areaBean = areaTransformer.fromEntityToBeanWithCity(areaEntity, LANG_AR);
        return areaBean;
    }

    @Override
    @Transactional
    public AreaBean addArea(AreaBean areaBean) {
        AreaEntity areaEntity = areaTransformer.fromBeanToEntity(areaBean);
        AreaEntity addedAreaEntity = areaRepo.add(areaEntity);
        AreaBean resultAreaBean = areaTransformer.fromEntityToBean(addedAreaEntity, LANG_EN);
        return resultAreaBean;
    }

    @Override
    @Transactional
    public List<AreaBean> findAreaList() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @Transactional
    public void removeArea(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
}
