package net.web.app.senior.beans;

import java.util.HashSet;
import java.util.Set;

public class ProviderBean {

    private Integer id;
    private String name;
    private String nameAr;
    private String nameEn;
    private String defaultLogoPath;
    private String logoPathEn;
    private String hotline;

    public String getHotline() {
        return hotline;
    }

    public ProviderBean(Integer id, String name, String nameAr, String nameEn, String defaultLogoPath, String logoPathEn, String hotline, String logoPathAr) {
        this.id = id;
        this.name = name;
        this.nameAr = nameAr;
        this.nameEn = nameEn;
        this.defaultLogoPath = defaultLogoPath;
        this.logoPathEn = logoPathEn;
        this.hotline = hotline;
        this.logoPathAr = logoPathAr;
    }

    public void setHotline(String hotline) {
        this.hotline = hotline;
    }

    public Integer getId() {
        return id;
    }

    public ProviderBean() {
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getDefaultLogoPath() {
        return defaultLogoPath;
    }

    public void setDefaultLogoPath(String defaultLogoPath) {
        this.defaultLogoPath = defaultLogoPath;
    }

    public String getLogoPathEn() {
        return logoPathEn;
    }

    public void setLogoPathEn(String logoPathEn) {
        this.logoPathEn = logoPathEn;
    }

    public String getLogoPathAr() {
        return logoPathAr;
    }

    public Set<BranchBean> getBranchesBean() {
        return branchesBean;
    }

    public void setBranchesBean(Set<BranchBean> branchesBean) {
        this.branchesBean = branchesBean;
    }

    public void setLogoPathAr(String logoPathAr) {
        this.logoPathAr = logoPathAr;
    }

    private String logoPathAr;

    private Set<CategoryBean> categoriesBean = new HashSet<>(0);
    private Set<BranchBean> branchesBean = new HashSet<>(0);
    private Set<ProviderUserBean> providerUsersBean = new HashSet<>(0);

    public Set<CategoryBean> getCategoriesBean() {
        return categoriesBean;
    }

    public void setCategoriesBean(Set<CategoryBean> categoriesBean) {
        this.categoriesBean = categoriesBean;
    }

    public Set<ProviderUserBean> getProviderUsersBean() {
        return providerUsersBean;
    }

    public void setProviderUsersBean(Set<ProviderUserBean> providerUsersBean) {
        this.providerUsersBean = providerUsersBean;
    }

}
