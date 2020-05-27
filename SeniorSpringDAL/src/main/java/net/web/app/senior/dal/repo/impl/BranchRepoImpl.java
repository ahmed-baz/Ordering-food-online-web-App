package net.web.app.senior.dal.repo.impl;

import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import net.web.app.senior.dal.entity.BranchEntity;
import net.web.app.senior.dal.repo.AbstractEntityRepo;
import net.web.app.senior.dal.repo.BranchRepo;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class BranchRepoImpl extends AbstractEntityRepo<BranchEntity> implements  BranchRepo{

    public BranchRepoImpl() {
        super(BranchEntity.class);
    }

    @Override
    public List<BranchEntity> searchByName(String keyword) {
        String pattern = "%" + keyword + "%";
        CriteriaBuilder criteriaBuilder = getCurrentSession().getCriteriaBuilder();
        CriteriaQuery<BranchEntity> branchCirteriaQuery = criteriaBuilder.createQuery(BranchEntity.class);
        Root<BranchEntity> branchRoot = branchCirteriaQuery.from(BranchEntity.class);
        branchCirteriaQuery.select(branchRoot);
        Predicate[] likeConditions = new Predicate[7];
        likeConditions[0] = criteriaBuilder.like(branchRoot.get("nameAr"), pattern);
        likeConditions[1] = criteriaBuilder.like(branchRoot.get("nameEn"), pattern);
        likeConditions[2] = criteriaBuilder.like(branchRoot.get("phone"), pattern);
        likeConditions[3] = criteriaBuilder.like(branchRoot.get("area").get("nameAr"), pattern);
        likeConditions[4] = criteriaBuilder.like(branchRoot.get("area").get("nameEn"), pattern);
        likeConditions[5] = criteriaBuilder.like(branchRoot.get("provider").get("nameAr"), pattern);
        likeConditions[6] = criteriaBuilder.like(branchRoot.get("provider").get("nameEn"), pattern);

        branchCirteriaQuery.where(criteriaBuilder.or(likeConditions));
        branchCirteriaQuery.orderBy(criteriaBuilder.asc(branchRoot.get("nameEn")));
        Query<BranchEntity> branchQuery = getCurrentSession().createQuery(branchCirteriaQuery);
        List<BranchEntity> branchResultList = branchQuery.getResultList();
        return branchResultList;
    }

}
