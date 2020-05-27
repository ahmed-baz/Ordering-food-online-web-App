
package net.web.app.senior.dal.repo.impl;

import net.web.app.senior.dal.entity.DeliveryAreaEntity;
import net.web.app.senior.dal.repo.AbstractEntityRepo;
import net.web.app.senior.dal.repo.DeliveryAreaRepo;
import org.springframework.stereotype.Repository;

@Repository
public class DeliveryAreaRepoImpl extends AbstractEntityRepo<DeliveryAreaEntity> implements DeliveryAreaRepo{
    
    public DeliveryAreaRepoImpl() {
        super(DeliveryAreaEntity.class);
    }
    
}
