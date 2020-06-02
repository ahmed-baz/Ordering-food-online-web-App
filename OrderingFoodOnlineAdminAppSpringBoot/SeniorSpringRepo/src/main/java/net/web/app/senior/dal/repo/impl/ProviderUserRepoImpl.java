package net.web.app.senior.dal.repo.impl;

import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import net.web.app.senior.dal.entity.ProviderUserEntity;
import net.web.app.senior.dal.repo.AbstractEntityRepo;
import net.web.app.senior.dal.repo.ProviderUserRepo;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class ProviderUserRepoImpl extends AbstractEntityRepo<ProviderUserEntity> implements ProviderUserRepo {

    public ProviderUserRepoImpl() {
        super(ProviderUserEntity.class);
    }

    @Override
    public List<ProviderUserEntity> findProviderUserListByProviderId(Integer id) {
        CriteriaBuilder criteriaBuilder = getCurrentSession().getCriteriaBuilder();
        CriteriaQuery<ProviderUserEntity> providerUserCirteriaQuery = criteriaBuilder.createQuery(ProviderUserEntity.class);
        Root<ProviderUserEntity> provideruserRoot = providerUserCirteriaQuery.from(ProviderUserEntity.class);
        providerUserCirteriaQuery.select(provideruserRoot);
        Predicate[] likeConditions = new Predicate[1];
        likeConditions[0] = criteriaBuilder.equal(provideruserRoot.get("provider").get("id"), id);
        providerUserCirteriaQuery.where(criteriaBuilder.or(likeConditions));
        providerUserCirteriaQuery.orderBy(criteriaBuilder.asc(provideruserRoot.get("username")));
        Query<ProviderUserEntity> providerUserQuery = getCurrentSession().createQuery(providerUserCirteriaQuery);
        List<ProviderUserEntity> provideruserResultList = providerUserQuery.getResultList();
        return provideruserResultList;
    }

    @Override
    public List<ProviderUserEntity> findProviderUserListByBranchId(Integer id) {
        CriteriaBuilder criteriaBuilder = getCurrentSession().getCriteriaBuilder();
        CriteriaQuery<ProviderUserEntity> providerUserCirteriaQuery = criteriaBuilder.createQuery(ProviderUserEntity.class);
        Root<ProviderUserEntity> provideruserRoot = providerUserCirteriaQuery.from(ProviderUserEntity.class);
        providerUserCirteriaQuery.select(provideruserRoot);
        Predicate[] likeConditions = new Predicate[1];
        likeConditions[0] = criteriaBuilder.equal(provideruserRoot.get("branch").get("id"), id);
        providerUserCirteriaQuery.where(criteriaBuilder.or(likeConditions));
        providerUserCirteriaQuery.orderBy(criteriaBuilder.asc(provideruserRoot.get("username")));
        Query<ProviderUserEntity> providerUserQuery = getCurrentSession().createQuery(providerUserCirteriaQuery);
        List<ProviderUserEntity> provideruserResultList = providerUserQuery.getResultList();
        return provideruserResultList;
    }

}
