/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.web.app.senior.beans;

/**
 *
 * @author Ahmed Baz
 */
public class DeliveryAreaBean {

    private Integer id;
    private AreaBean areaBean;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public DeliveryAreaBean(AreaBean areaBean, BranchBean branchBean, float deliveryFees, int deliverInMinutes) {
        this.areaBean = areaBean;
        this.branchBean = branchBean;
        this.deliveryFees = deliveryFees;
        this.deliverInMinutes = deliverInMinutes;
    }

    public AreaBean getAreaBean() {
        return areaBean;
    }

    public void setAreaBean(AreaBean areaBean) {
        this.areaBean = areaBean;
    }

    public BranchBean getBranchBean() {
        return branchBean;
    }

    public void setBranchBean(BranchBean branchBean) {
        this.branchBean = branchBean;
    }

    public float getDeliveryFees() {
        return deliveryFees;
    }

    public void setDeliveryFees(float deliveryFees) {
        this.deliveryFees = deliveryFees;
    }

    public int getDeliverInMinutes() {
        return deliverInMinutes;
    }

    public void setDeliverInMinutes(int deliverInMinutes) {
        this.deliverInMinutes = deliverInMinutes;
    }
    private BranchBean branchBean;
    private float deliveryFees;

    public DeliveryAreaBean(Integer id, AreaBean areaBean, BranchBean branchBean, float deliveryFees, int deliverInMinutes) {
        this.id = id;
        this.areaBean = areaBean;
        this.branchBean = branchBean;
        this.deliveryFees = deliveryFees;
        this.deliverInMinutes = deliverInMinutes;
    }

    public DeliveryAreaBean() {
    }
    private int deliverInMinutes;
}
