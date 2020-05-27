package net.web.app.senior.beans;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class OrderBean {

    private Integer id;
    private AreaBean area;
    private BranchBean branch;

    public OrderBean() {
    }

    public OrderBean(Integer id, AreaBean area, BranchBean branch, ConsumerBean consumer, ConsumerAddressBean consumerAddress, Date orderedAt, float deliveryFees, String status) {
        this.id = id;
        this.area = area;
        this.branch = branch;
        this.consumer = consumer;
        this.consumerAddress = consumerAddress;
        this.orderedAt = orderedAt;
        this.deliveryFees = deliveryFees;
        this.status = status;
    }

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

    public BranchBean getBranch() {
        return branch;
    }

    public void setBranch(BranchBean branch) {
        this.branch = branch;
    }

    public ConsumerBean getConsumer() {
        return consumer;
    }

    public void setConsumer(ConsumerBean consumer) {
        this.consumer = consumer;
    }

    public ConsumerAddressBean getConsumerAddress() {
        return consumerAddress;
    }

    public void setConsumerAddress(ConsumerAddressBean consumerAddress) {
        this.consumerAddress = consumerAddress;
    }

    public Date getOrderedAt() {
        return orderedAt;
    }

    public void setOrderedAt(Date orderedAt) {
        this.orderedAt = orderedAt;
    }

    public float getDeliveryFees() {
        return deliveryFees;
    }

    public void setDeliveryFees(float deliveryFees) {
        this.deliveryFees = deliveryFees;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Set<OrderItemBean> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(Set<OrderItemBean> orderItems) {
        this.orderItems = orderItems;
    }

    public OrderBean(AreaBean area, BranchBean branch, ConsumerBean consumer, ConsumerAddressBean consumerAddress, Date orderedAt, float deliveryFees, String status) {
        this.area = area;
        this.branch = branch;
        this.consumer = consumer;
        this.consumerAddress = consumerAddress;
        this.orderedAt = orderedAt;
        this.deliveryFees = deliveryFees;
        this.status = status;
    }
    private ConsumerBean consumer;
    private ConsumerAddressBean consumerAddress;
    private Date orderedAt;
    private float deliveryFees;
    private String status;
    private Set<OrderItemBean> orderItems = new HashSet<OrderItemBean>(0);
}
