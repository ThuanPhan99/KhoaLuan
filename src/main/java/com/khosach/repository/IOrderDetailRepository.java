/*
 * @author THUAN-PHAN
 * @date May 17, 2020
 * @version 1.0
 */

package com.khosach.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.khosach.dto.RevenueDTO;
import com.khosach.entity.OrderDetailEntity;
import org.springframework.data.repository.query.Param;

public interface IOrderDetailRepository extends JpaRepository<OrderDetailEntity, Long> {
	List<OrderDetailEntity> findAllByOrders_OrderID(Long orderID);

	List<OrderDetailEntity> findAllByOrders_Users_IdAndOrders_Status(long userID, int status);

	List<OrderDetailEntity> findAllByOrders_Users_Id(long userID);

	List<OrderDetailEntity> findAllByOrders_OrderIDAndStatus(Long orderID, int status);

	@Query("SELECT New com.khosach.dto.RevenueDTO( SUM(od.price),YEAR(o.deliveryDate)) FROM OrderDetailEntity od JOIN od.orders o  Where o.status = 6 and od.status=1 GROUP BY YEAR(o.deliveryDate) ORDER BY YEAR(o.deliveryDate)")
	List<RevenueDTO> findRevenue();

	@Query("select SUM (odr.quantity) from OrderDetailEntity  odr where odr.products.productID = :prodId")
	Long countProductSell(@Param("prodId") Long prodId);

}
