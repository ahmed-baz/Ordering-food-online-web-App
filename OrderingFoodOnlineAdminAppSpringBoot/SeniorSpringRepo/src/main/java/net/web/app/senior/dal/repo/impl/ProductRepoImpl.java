
package net.web.app.senior.dal.repo.impl;

import net.web.app.senior.dal.entity.ProductEntity;
import net.web.app.senior.dal.repo.AbstractEntityRepo;
import net.web.app.senior.dal.repo.ProductRepo;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepoImpl extends AbstractEntityRepo<ProductEntity> implements ProductRepo{
    
    public ProductRepoImpl() {
        super(ProductEntity.class);
    }
    
}
