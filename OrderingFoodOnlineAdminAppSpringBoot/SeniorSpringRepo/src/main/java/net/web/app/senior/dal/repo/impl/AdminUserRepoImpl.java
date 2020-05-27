package net.web.app.senior.dal.repo.impl;

import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import net.web.app.senior.dal.entity.AdminUserEntity;
import net.web.app.senior.dal.repo.AbstractEntityRepo;
import net.web.app.senior.dal.repo.AdminUserRepo;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class AdminUserRepoImpl extends AbstractEntityRepo<AdminUserEntity> implements AdminUserRepo {

    public AdminUserRepoImpl() {
        super(AdminUserEntity.class);
    }

    public Boolean checkLogin(String userName, String password) {
        boolean userFound = false;
        AdminUserEntity adminUserEntity = new AdminUserEntity();
        CriteriaBuilder criteriaBuilder = getCurrentSession().getCriteriaBuilder();
        CriteriaQuery<AdminUserEntity> adminUserCirteriaQuery = criteriaBuilder.createQuery(AdminUserEntity.class);
        Root<AdminUserEntity> root = adminUserCirteriaQuery.from(AdminUserEntity.class);
        adminUserCirteriaQuery.select(root);
        Predicate[] conditions = new Predicate[3];
        conditions[0] = criteriaBuilder.equal(root.get("username"), userName.toLowerCase());
        conditions[1] = criteriaBuilder.equal(root.get("password"), password);
        conditions[2] = criteriaBuilder.equal(root.get("active"), 1);
        adminUserCirteriaQuery.where(criteriaBuilder.and(conditions));
        Query<AdminUserEntity> adminUserQuery = getCurrentSession().createQuery(adminUserCirteriaQuery);
        List<AdminUserEntity> resultList = adminUserQuery.getResultList();
        if (resultList.size() > 0) {
            userFound = true;
        }
        return userFound;
    }

}
