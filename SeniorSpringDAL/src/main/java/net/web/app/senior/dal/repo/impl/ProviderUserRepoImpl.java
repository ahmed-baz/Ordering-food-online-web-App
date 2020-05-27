package net.web.app.senior.dal.repo.impl;

import net.web.app.senior.dal.entity.ProviderUserEntity;
import net.web.app.senior.dal.repo.AbstractEntityRepo;
import net.web.app.senior.dal.repo.ProviderUserRepo;
import org.springframework.stereotype.Repository;


@Repository
public class ProviderUserRepoImpl extends AbstractEntityRepo<ProviderUserEntity> implements ProviderUserRepo {

    public ProviderUserRepoImpl() {
        super(ProviderUserEntity.class);
    }

}
