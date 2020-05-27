
package net.web.app.senior.dal.repo.impl;

import net.web.app.senior.dal.entity.OrderItemEntity;
import net.web.app.senior.dal.repo.AbstractEntityRepo;
import net.web.app.senior.dal.repo.OrderItemRepo;
import org.springframework.stereotype.Repository;


@Repository
public class OrderItemRepoImpl extends AbstractEntityRepo<OrderItemEntity> implements OrderItemRepo{
    
    public OrderItemRepoImpl() {
        super(OrderItemEntity.class);
    }
    
}
