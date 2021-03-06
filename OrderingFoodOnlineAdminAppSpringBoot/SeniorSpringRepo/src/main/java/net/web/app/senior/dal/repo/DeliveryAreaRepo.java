/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.web.app.senior.dal.repo;

import java.util.List;
import net.web.app.senior.dal.entity.DeliveryAreaEntity;

/**
 *
 * @author Ahmed Baz
 */
public interface DeliveryAreaRepo extends CommonRepo<DeliveryAreaEntity> {

    public List<DeliveryAreaEntity> findDeliveryAreaListByBranchId(Integer id);

    public List<DeliveryAreaEntity> findDeliveryAreaListByProviderId(Integer id);

}
