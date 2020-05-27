
package net.web.app.senior.beans;

import java.util.HashSet;
import java.util.Set;

public class ConsumerBean {

    private Integer id;
    private String phone;
    private String email;
    private String password;
    private String fullname;
    private String gender;
    private Set<ConsumerAddressBean> consumerAddressesBean = new HashSet<>(0);
    private Set<OrderBean> ordersBean = new HashSet<>(0);
}
