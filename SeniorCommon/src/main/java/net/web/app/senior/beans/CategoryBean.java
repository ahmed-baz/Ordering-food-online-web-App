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
    private String nameAr;
    private String nameEn;
    private String description;
    private String descriptionAr;
    private String descriptionEn;
    private ProviderBean providerBean;
    private Set<ProductBean> productsBean = new HashSet<>(0);

}
