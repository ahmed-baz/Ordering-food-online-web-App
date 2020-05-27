
package net.web.app.senior.beans;


public class OrderItemBean {

    private Integer id;
    private OrderBean orderBean;
    private ProductBean productBean;
    private int quantity;
    private float price;

    public OrderItemBean(Integer id, OrderBean orderBean, ProductBean productBean, int quantity, float price) {
        this.id = id;
        this.orderBean = orderBean;
        this.productBean = productBean;
        this.quantity = quantity;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public OrderBean getOrderBean() {
        return orderBean;
    }

    public void setOrderBean(OrderBean orderBean) {
        this.orderBean = orderBean;
    }

    public ProductBean getProductBean() {
        return productBean;
    }

    public void setProductBean(ProductBean productBean) {
        this.productBean = productBean;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public OrderItemBean() {
    }

    public OrderItemBean(OrderBean orderBean, ProductBean productBean, int quantity, float price) {
        this.orderBean = orderBean;
        this.productBean = productBean;
        this.quantity = quantity;
        this.price = price;
    }
    
    
}
