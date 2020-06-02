
package net.web.app.senior.bll.transformer;

import net.web.app.senior.beans.OrderBean;
import net.web.app.senior.dal.entity.OrderEntity;
import org.springframework.stereotype.Component;

@Component
public class OrderTransformer implements GeneralTransformer<OrderEntity, OrderBean> {

    @Override
    public OrderEntity fromBeanToEntity(OrderBean bean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public OrderBean fromEntityToBean(OrderEntity entity, String lang) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
