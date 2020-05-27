package net.web.app.senior.dal.repo.impl;

import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import net.web.app.senior.dal.entity.CategoryEntity;
import net.web.app.senior.dal.repo.AbstractEntityRepo;
import net.web.app.senior.dal.repo.CategoryRepo;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class CategoryRepoImpl extends AbstractEntityRepo<CategoryEntity> implements CategoryRepo {

    public CategoryRepoImpl() {
        super(CategoryEntity.class);
    }

    @Override
    public List<CategoryEntity> findCategoryListByProviderId(Integer id) {
        CriteriaBuilder criteriaBuilder = getCurrentSession().getCriteriaBuilder();
        CriteriaQuery<CategoryEntity> categoryCirteriaQuery = criteriaBuilder.createQuery(CategoryEntity.class);
        Root<CategoryEntity> categoryRoot = categoryCirteriaQuery.from(CategoryEntity.class);
        categoryCirteriaQuery.select(categoryRoot);
        Predicate[] likeConditions = new Predicate[1];
        likeConditions[0] = criteriaBuilder.equal(categoryRoot.get("provider").get("id"), id);
        categoryCirteriaQuery.where(criteriaBuilder.or(likeConditions));
        categoryCirteriaQuery.orderBy(criteriaBuilder.asc(categoryRoot.get("nameEn")));
        Query<CategoryEntity> categoryQuery = getCurrentSession().createQuery(categoryCirteriaQuery);
        List<CategoryEntity> categoryResultList = categoryQuery.getResultList();
        return categoryResultList;
    }
}
