package net.web.app.senior.dal.repo.impl;

import net.web.app.senior.dal.entity.CategoryEntity;
import net.web.app.senior.dal.repo.AbstractEntityRepo;
import net.web.app.senior.dal.repo.CategoryRepo;
import org.springframework.stereotype.Repository;


@Repository
public class CategoryRepoImpl extends AbstractEntityRepo<CategoryEntity> implements CategoryRepo{

    public CategoryRepoImpl() {
        super(CategoryEntity.class);
    }
}
