
package net.web.app.senior.dal.repo.impl;

import net.web.app.senior.dal.entity.ProviderEntity;
import net.web.app.senior.dal.repo.AbstractEntityRepo;
import net.web.app.senior.dal.repo.ProviderRepo;
import org.springframework.stereotype.Repository;


@Repository
public class ProviderRepoImpl extends AbstractEntityRepo<ProviderEntity> implements ProviderRepo{
    
    public ProviderRepoImpl() {
        super(ProviderEntity.class);
    }
    
}
