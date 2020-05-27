package net.web.app.senior.dal.repo.impl;

import net.web.app.senior.dal.entity.ConsumerEntity;
import net.web.app.senior.dal.repo.AbstractEntityRepo;
import net.web.app.senior.dal.repo.ConsumerRepo;
import org.springframework.stereotype.Repository;


@Repository
public class ConsumerRepoImpl extends AbstractEntityRepo<ConsumerEntity> implements ConsumerRepo {

    public ConsumerRepoImpl() {
        super(ConsumerEntity.class);
    }

}
