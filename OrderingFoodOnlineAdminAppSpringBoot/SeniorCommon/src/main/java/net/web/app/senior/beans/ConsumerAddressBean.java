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
public class ConsumerAddressBean {

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getFlat() {
        return flat;
    }

    public void setFlat(String flat) {
        this.flat = flat;
    }

    public String getLandmark() {
        return landmark;
    }

    public void setLandmark(String landmark) {
        this.landmark = landmark;
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

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public byte getActive() {
        return active;
    }

    public void setActive(byte active) {
        this.active = active;
    }

    public AreaBean getAreaBean() {
        return areaBean;
    }

    public void setAreaBean(AreaBean areaBean) {
        this.areaBean = areaBean;
    }

    public ConsumerBean getConsumerBean() {
        return consumerBean;
    }

    public void setConsumerBean(ConsumerBean consumerBean) {
        this.consumerBean = consumerBean;
    }

    public Set<OrderBean> getOrderBeans() {
        return orderBeans;
    }

    public void setOrderBeans(Set<OrderBean> orderBeans) {
        this.orderBeans = orderBeans;
    }

    public ConsumerAddressBean(String street, String building, String floor, String flat, String landmark, BigDecimal lat, BigDecimal lng, String label, byte active, AreaBean areaBean, ConsumerBean consumerBean) {
        this.street = street;
        this.building = building;
        this.floor = floor;
        this.flat = flat;
        this.landmark = landmark;
        this.lat = lat;
        this.lng = lng;
        this.label = label;
        this.active = active;
        this.areaBean = areaBean;
        this.consumerBean = consumerBean;
    }

    public ConsumerAddressBean() {
    }

    public ConsumerAddressBean(Integer id, String street, String building, String floor, String flat, String landmark, BigDecimal lat, BigDecimal lng, String label, byte active, AreaBean areaBean, ConsumerBean consumerBean) {
        this.id = id;
        this.street = street;
        this.building = building;
        this.floor = floor;
        this.flat = flat;
        this.landmark = landmark;
        this.lat = lat;
        this.lng = lng;
        this.label = label;
        this.active = active;
        this.areaBean = areaBean;
        this.consumerBean = consumerBean;
    }

    private Integer id;
    private String street;
    private String building;
    private String floor;
    private String flat;
    private String landmark;
    private BigDecimal lat;
    private BigDecimal lng;
    private String label;
    private byte active;
    private AreaBean areaBean;
    private ConsumerBean consumerBean;
    private Set<OrderBean> orderBeans = new HashSet<>(0);
}
