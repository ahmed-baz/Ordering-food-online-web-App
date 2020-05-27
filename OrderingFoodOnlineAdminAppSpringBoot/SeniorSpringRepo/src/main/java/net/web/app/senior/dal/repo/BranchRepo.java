package net.web.app.senior.dal.repo;

import java.util.List;
import net.web.app.senior.dal.entity.BranchEntity;

public interface BranchRepo extends CommonRepo<BranchEntity> {

    public List<BranchEntity> searchByName(String keyword);

    public List<BranchEntity> findBranchListByProviderId(Integer id);
}
