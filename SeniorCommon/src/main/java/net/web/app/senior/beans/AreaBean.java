package net.web.app.senior.beans;

import java.util.HashSet;
import java.util.Set;

public class AreaBean {

    private Integer id;
    private CityBean cityBean;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    private String nameAr;
    private String nameEn;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public CityBean getCityBean() {
        return cityBean;
    }

    public void setCityBean(CityBean cityBean) {
        this.cityBean = cityBean;
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

    public Set<ConsumerAddressBean> getConsumerAddressesBean() {
        return consumerAddressesBean;
    }

    public void setConsumerAddressesBean(Set<ConsumerAddressBean> consumerAddressesBean) {
        this.consumerAddressesBean = consumerAddressesBean;
    }

    public Set<DeliveryAreaBean> getDeliveryAreasAreaBean() {
        return deliveryAreasAreaBean;
    }

    public void setDeliveryAreasAreaBean(Set<DeliveryAreaBean> deliveryAreasAreaBean) {
        this.deliveryAreasAreaBean = deliveryAreasAreaBean;
    }

    public Set<OrderBean> getOrdersBean() {
        return ordersBean;
    }

    public void setOrdersBean(Set<OrderBean> ordersBean) {
        this.ordersBean = ordersBean;
    }

    public Set<BranchBean> getBranchesBean() {
        return branchesBean;
    }

    public void setBranchesBean(Set<BranchBean> branchesBean) {
        this.branchesBean = branchesBean;
    }

    public AreaBean() {
    }

    private Set<ConsumerAddressBean> consumerAddressesBean = new HashSet<>(0);
    private Set<DeliveryAreaBean> deliveryAreasAreaBean = new HashSet<>(0);
    private Set<OrderBean> ordersBean = new HashSet<>(0);
    private Set<BranchBean> branchesBean = new HashSet<>(0);

}
