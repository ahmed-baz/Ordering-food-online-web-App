package net.web.app.senior.dal.repo.impl;

import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import net.web.app.senior.dal.entity.CityEntity;
import net.web.app.senior.dal.repo.AbstractEntityRepo;
import net.web.app.senior.dal.repo.CityRepo;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class CityRepoImpl extends AbstractEntityRepo<CityEntity> implements CityRepo{

    public CityRepoImpl() {
        super(CityEntity.class);
        super.setDefaultOrder("nameEn");
    }

    @Override
    public List<CityEntity> searchByName(String keyword) {
        String pattern = "%" + keyword + "%";
        CriteriaBuilder criteriaBuilder = getCurrentSession().getCriteriaBuilder();
        CriteriaQuery<CityEntity> cityCirteriaQuery = criteriaBuilder.createQuery(CityEntity.class);
        Root<CityEntity> root = cityCirteriaQuery.from(CityEntity.class);
        cityCirteriaQuery.select(root);
        Predicate[] likeConditions = new Predicate[2];
        likeConditions[0] = criteriaBuilder.like(root.get("nameAr"), pattern);
        likeConditions[1] = criteriaBuilder.like(root.get("nameEn"), pattern);
        cityCirteriaQuery.where(criteriaBuilder.or(likeConditions));
        cityCirteriaQuery.orderBy(criteriaBuilder.asc(root.get("nameEn")));
        Query<CityEntity> cityQuery = getCurrentSession().createQuery(cityCirteriaQuery);
        List<CityEntity> cityResultList = cityQuery.getResultList();
        return cityResultList;
    }

}
