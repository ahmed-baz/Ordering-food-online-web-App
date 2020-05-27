
package net.web.app.senior.beans;

import java.util.HashSet;
import java.util.Set;

public class ConsumerBean {

    private Integer id;
    private String phone;
    private String email;
    private String password;

    public ConsumerBean() {
    }

    public ConsumerBean(String phone, String email, String password, String fullname, String gender) {
        this.phone = phone;
        this.email = email;
        this.password = password;
        this.fullname = fullname;
        this.gender = gender;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Set<ConsumerAddressBean> getConsumerAddressesBean() {
        return consumerAddressesBean;
    }

    public void setConsumerAddressesBean(Set<ConsumerAddressBean> consumerAddressesBean) {
        this.consumerAddressesBean = consumerAddressesBean;
    }

    public Set<OrderBean> getOrdersBean() {
        return ordersBean;
    }

    public void setOrdersBean(Set<OrderBean> ordersBean) {
        this.ordersBean = ordersBean;
    }

    public ConsumerBean(Integer id, String phone, String email, String password, String fullname, String gender) {
        this.id = id;
        this.phone = phone;
        this.email = email;
        this.password = password;
        this.fullname = fullname;
        this.gender = gender;
    }
    private String fullname;
    private String gender;
    private Set<ConsumerAddressBean> consumerAddressesBean = new HashSet<>(0);
    private Set<OrderBean> ordersBean = new HashSet<>(0);
}
