package net.web.app.senior.dal.repo.impl;

import net.web.app.senior.dal.entity.ConsumerAddressEntity;
import net.web.app.senior.dal.repo.AbstractEntityRepo;
import net.web.app.senior.dal.repo.ConsumerAddressRepo;
import org.springframework.stereotype.Repository;


@Repository
public class ConsumerAddressRepoImpl extends AbstractEntityRepo<ConsumerAddressEntity> implements ConsumerAddressRepo {

    public ConsumerAddressRepoImpl() {
        super(ConsumerAddressEntity.class);
    }
}
