package net.web.app.senior.dal.repo;

import java.util.List;
import net.web.app.senior.dal.entity.CategoryEntity;

public interface CategoryRepo extends CommonRepo<CategoryEntity> {

    public List<CategoryEntity> findCategoryListByProviderId(Integer id);

}
