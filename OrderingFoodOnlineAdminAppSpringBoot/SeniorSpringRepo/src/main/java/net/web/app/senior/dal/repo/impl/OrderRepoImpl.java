/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.web.app.senior.dal.repo.impl;

import net.web.app.senior.dal.entity.OrderEntity;
import net.web.app.senior.dal.repo.AbstractEntityRepo;
import net.web.app.senior.dal.repo.OrderRepo;
import org.springframework.stereotype.Repository;

@Repository
public class OrderRepoImpl extends AbstractEntityRepo<OrderEntity> implements OrderRepo{
    
    public OrderRepoImpl() {
        super(OrderEntity.class);
    }
    
}
