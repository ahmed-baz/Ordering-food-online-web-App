package net.web.app.senior.dal.repo.impl;

import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import net.web.app.senior.dal.entity.DeliveryAreaEntity;
import net.web.app.senior.dal.repo.AbstractEntityRepo;
import net.web.app.senior.dal.repo.DeliveryAreaRepo;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class DeliveryAreaRepoImpl extends AbstractEntityRepo<DeliveryAreaEntity> implements DeliveryAreaRepo {
    
    public DeliveryAreaRepoImpl() {
        super(DeliveryAreaEntity.class);
    }
    
    @Override
    public List<DeliveryAreaEntity> findDeliveryAreaListByBranchId(Integer id) {
        CriteriaBuilder criteriaBuilder = getCurrentSession().getCriteriaBuilder();
        CriteriaQuery<DeliveryAreaEntity> areaCirteriaQuery = criteriaBuilder.createQuery(DeliveryAreaEntity.class);
        Root<DeliveryAreaEntity> root = areaCirteriaQuery.from(DeliveryAreaEntity.class);
        areaCirteriaQuery.select(root);
        Predicate[] likeConditions = new Predicate[1];
        likeConditions[0] = criteriaBuilder.equal(root.get("branch").get("id"), id);
        areaCirteriaQuery.where(criteriaBuilder.or(likeConditions));
        areaCirteriaQuery.orderBy(criteriaBuilder.asc(root.get("area").get("nameEn")));
        Query<DeliveryAreaEntity> araeQuery = getCurrentSession().createQuery(areaCirteriaQuery);
        List<DeliveryAreaEntity> araeResultList = araeQuery.getResultList();
        return araeResultList;
    }
    
    @Override
    public List<DeliveryAreaEntity> findDeliveryAreaListByProviderId(Integer id) {
        CriteriaBuilder criteriaBuilder = getCurrentSession().getCriteriaBuilder();
        CriteriaQuery<DeliveryAreaEntity> areaCirteriaQuery = criteriaBuilder.createQuery(DeliveryAreaEntity.class);
        Root<DeliveryAreaEntity> root = areaCirteriaQuery.from(DeliveryAreaEntity.class);
        areaCirteriaQuery.select(root);
        Predicate[] likeConditions = new Predicate[1];
        likeConditions[0] = criteriaBuilder.equal(root.get("branch").get("provider").get("id"), id);
        areaCirteriaQuery.where(criteriaBuilder.or(likeConditions));
        areaCirteriaQuery.orderBy(criteriaBuilder.asc(root.get("area").get("nameEn")));
        Query<DeliveryAreaEntity> araeQuery = getCurrentSession().createQuery(areaCirteriaQuery);
        List<DeliveryAreaEntity> araeResultList = araeQuery.getResultList();
        return araeResultList;
    }
    
}
