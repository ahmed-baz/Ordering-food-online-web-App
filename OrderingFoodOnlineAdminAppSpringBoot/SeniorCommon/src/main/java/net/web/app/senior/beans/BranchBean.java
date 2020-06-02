/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.web.app.senior.beans;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Ahmed Baz
 */
public class BranchBean {

    private Integer id;
    private AreaBean area;
    private ProviderBean provider;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public AreaBean getArea() {
        return area;
    }

    public void setArea(AreaBean area) {
        this.area = area;
    }

    public ProviderBean getProvider() {
        return provider;
    }

    public void setProvider(ProviderBean provider) {
        this.provider = provider;
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

    public String getOpenAt() {
        return openAt;
    }

    public void setOpenAt(String openAt) {
        this.openAt = openAt;
    }

    public String getCloseAt() {
        return closeAt;
    }

    public void setCloseAt(String closeAt) {
        this.closeAt = closeAt;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public BigDecimal getLat() {
        return lat;
    }

    public void setLat(BigDecimal lat) {
        this.lat = lat;
    }

    public BigDecimal getLng() {
        return lng;
    }

    public void setLng(BigDecimal lng) {
        this.lng = lng;
    }

    public Set<DeliveryAreaBean> getDeliveryAreas() {
        return deliveryAreas;
    }

    public void setDeliveryAreas(Set<DeliveryAreaBean> deliveryAreas) {
        this.deliveryAreas = deliveryAreas;
    }

    public Set<ProviderUsersBean> getProviderUsers() {
        return providerUsers;
    }

    public void setProviderUsers(Set<ProviderUsersBean> providerUsers) {
        this.providerUsers = providerUsers;
    }

    public Set<OrderBean> getOrders() {
        return orders;
    }

    public void setOrders(Set<OrderBean> orders) {
        this.orders = orders;
    }
    private String name;
    private String nameAr;
    private String nameEn;
    private String openAt;
    private String closeAt;
    private String phone;
    private BigDecimal lat;
    private BigDecimal lng;
    private Set<DeliveryAreaBean> deliveryAreas = new HashSet<>(0);
    private Set<ProviderUsersBean> providerUsers = new HashSet<>(0);
    private Set<OrderBean> orders = new HashSet<>(0);
}
