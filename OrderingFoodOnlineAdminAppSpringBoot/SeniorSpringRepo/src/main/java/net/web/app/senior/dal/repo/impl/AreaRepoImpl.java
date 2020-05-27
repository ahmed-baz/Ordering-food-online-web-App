package net.web.app.senior.dal.repo.impl;

import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import net.web.app.senior.dal.entity.AreaEntity;
import net.web.app.senior.dal.entity.AreaEntity;
import net.web.app.senior.dal.repo.AbstractEntityRepo;
import net.web.app.senior.dal.repo.AreaRepo;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class AreaRepoImpl extends AbstractEntityRepo<AreaEntity> implements AreaRepo {
    
    public AreaRepoImpl() {
        super(AreaEntity.class);
    }
    
    @Override
    public void removeAllList() {
        findList().forEach(area -> remove(area.getId()));
    }
    
    @Override
    public List<AreaEntity> findAreaListByCityId(Integer id) {
        CriteriaBuilder criteriaBuilder = getCurrentSession().getCriteriaBuilder();
        CriteriaQuery<AreaEntity> areaCirteriaQuery = criteriaBuilder.createQuery(AreaEntity.class);
        Root<AreaEntity> root = areaCirteriaQuery.from(AreaEntity.class);
        areaCirteriaQuery.select(root);
        Predicate[] likeConditions = new Predicate[1];
        likeConditions[0] = criteriaBuilder.equal(root.get("city").get("id"), id);
        areaCirteriaQuery.where(criteriaBuilder.or(likeConditions));
        areaCirteriaQuery.orderBy(criteriaBuilder.asc(root.get("nameEn")));
        Query<AreaEntity> araeQuery = getCurrentSession().createQuery(areaCirteriaQuery);
        List<AreaEntity> araeResultList = araeQuery.getResultList();
        return araeResultList;
    }
    
}
