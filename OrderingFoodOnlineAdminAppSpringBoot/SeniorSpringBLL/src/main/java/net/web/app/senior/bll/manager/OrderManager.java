package net.web.app.senior.bll.manager;

import java.util.List;
import java.util.Set;
import net.web.app.senior.beans.OrderBean;
import net.web.app.senior.beans.BranchBean;
import net.web.app.senior.beans.ProviderBean;

public interface OrderManager {

    public List<BranchBean> findBranchList();

    public Set<BranchBean> findBranchByProviderId(Integer id);

    public List<BranchBean> searchBranchByName(String name);

    public List<ProviderBean> findProviderList();

    public List<ProviderBean> searchProviderByName(String name);

    public OrderBean addOrder(OrderBean orderBean);

    public OrderBean updateOrder(OrderBean orderBean);

    public OrderBean cancelOrder(Integer id);
}
