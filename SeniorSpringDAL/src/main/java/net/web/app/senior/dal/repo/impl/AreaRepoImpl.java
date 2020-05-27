package net.web.app.senior.dal.repo.impl;

import net.web.app.senior.dal.entity.AreaEntity;
import net.web.app.senior.dal.repo.AbstractEntityRepo;
import net.web.app.senior.dal.repo.AreaRepo;
import org.springframework.stereotype.Repository;

@Repository
public class AreaRepoImpl extends AbstractEntityRepo<AreaEntity> implements AreaRepo {

    public AreaRepoImpl() {
        super(AreaEntity.class);
    }

}
