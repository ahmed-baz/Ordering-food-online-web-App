/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.web.app.senior.beans;

import java.util.HashSet;
import java.util.Set;

public class CategoryBean {

    private Integer id;
    private String name;

    public Integer getId() {
        return id;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescriptionAr() {
        return descriptionAr;
    }

    public void setDescriptionAr(String descriptionAr) {
        this.descriptionAr = descriptionAr;
    }

    public String getDescriptionEn() {
        return descriptionEn;
    }

    public void setDescriptionEn(String descriptionEn) {
        this.descriptionEn = descriptionEn;
    }

    public ProviderBean getProviderBean() {
        return providerBean;
    }

    public void setProviderBean(ProviderBean providerBean) {
        this.providerBean = providerBean;
    }

    public Set<ProductBean> getProductsBean() {
        return productsBean;
    }

    public void setProductsBean(Set<ProductBean> productsBean) {
        this.productsBean = productsBean;
    }
    private String nameAr;
    private String nameEn;
    private String description;
    private String descriptionAr;
    private String descriptionEn;
    private ProviderBean providerBean;
    private Set<ProductBean> productsBean = new HashSet<>(0);

    public CategoryBean() {
    }

    public CategoryBean(Integer id, String name, String nameAr, String nameEn, String description, String descriptionAr, String descriptionEn, ProviderBean providerBean) {
        this.id = id;
        this.name = name;
        this.nameAr = nameAr;
        this.nameEn = nameEn;
        this.description = description;
        this.descriptionAr = descriptionAr;
        this.descriptionEn = descriptionEn;
        this.providerBean = providerBean;
    }

    public CategoryBean(String name, String nameAr, String nameEn, String description, String descriptionAr, String descriptionEn, ProviderBean providerBean) {
        this.name = name;
        this.nameAr = nameAr;
        this.nameEn = nameEn;
        this.description = description;
        this.descriptionAr = descriptionAr;
        this.descriptionEn = descriptionEn;
        this.providerBean = providerBean;
    }

}
