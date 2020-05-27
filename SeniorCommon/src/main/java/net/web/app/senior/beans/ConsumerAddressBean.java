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
