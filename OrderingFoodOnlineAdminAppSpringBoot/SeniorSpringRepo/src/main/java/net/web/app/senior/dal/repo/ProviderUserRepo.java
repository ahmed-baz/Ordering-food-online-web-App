package net.web.app.senior.dal.repo;

import java.util.List;
import net.web.app.senior.dal.entity.ProviderUserEntity;

public interface ProviderUserRepo extends CommonRepo<ProviderUserEntity> {

    public List<ProviderUserEntity> findProviderUserListByProviderId(Integer id);

    public List<ProviderUserEntity> findProviderUserListByBranchId(Integer id);

}
