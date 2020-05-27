package net.web.app.senior.beans;

import java.util.HashSet;
import java.util.Set;

public class CityBean {

    public CityBean() {
    }

    public String getNameAr() {
        return nameAr;
    }

    public void setNameAr(String nameAr) {
        this.nameAr = nameAr;
    }

    public String getNameEn() {
        return nameEn;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public CityBean(Integer id, String nameAr, String nameEn, String name) {
        this.id = id;
        this.nameAr = nameAr;
        this.nameEn = nameEn;
        this.name = name;
    }
    private String nameAr;
    private String nameEn;
    private String name;
    private Set<AreaBean> areasBean = new HashSet<>(0);

    public Set<AreaBean> getAreasBean() {
        return areasBean;
    }

    public void setAreasBean(Set<AreaBean> areasBean) {
        this.areasBean = areasBean;
    }

}
