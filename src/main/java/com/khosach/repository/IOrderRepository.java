/*
 * @author THUAN-PHAN
 * @date May 17, 2020
 * @version 1.0
 */

package com.khosach.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.khosach.entity.OrderEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IOrderRepository extends JpaRepository<OrderEntity, Long> {
	OrderEntity findTop1ByOrderByOrderIDDesc();
	List<OrderEntity> findAllByStatus(int status);
	List<OrderEntity> findAllByUsers_IdAndStatus(long userID,int status );
	List<OrderEntity> findAllByUsers_Id(long userID);
	List<OrderEntity> findAllByStatusAndDeliveryDateGreaterThanEqualAndDeliveryDateLessThanEqual(int status, Date fromDate, Date toDate);
	List<OrderEntity> findAllByStatusAndDeliveryDateGreaterThanEqual(int status, Date fromDate);
	List<OrderEntity> findAllByStatusAndDeliveryDateLessThanEqual(int status, Date toDate);

	@Query(value = "SELECT dtl.productid, p.productname, CONCAT(a.firstname, a.lastname) as autName, p3.name, sum(dtl.quantity) quantity " +
			"FROM orders ord inner join orderdetail dtl on ord.orderid = dtl.orderid " +
			"inner join product p on dtl.productid = p.productid " +
			"inner join publishers p3 on p.publisherid = p3.publisherid " +
			"inner join productauthor p2 on p.productid = p2.productid " +
			"inner join authors a on p2.authorid = a.authorid " +
			"where ord.status != 5 group by dtl.productid, p.productname, a.firstname, a.lastname order by quantity desc ", nativeQuery = true)
	List<Object[]> findProductLike();

	@Query(value = "SELECT dtl.productid, p.productname, CONCAT(a.firstname, a.lastname) as autName, p3.name, sum(dtl.quantity) quantity " +
			"FROM orders ord inner join orderdetail dtl on ord.orderid = dtl.orderid " +
			"inner join product p on dtl.productid = p.productid " +
			"inner join publishers p3 on p.publisherid = p3.publisherid " +
			"inner join productauthor p2 on p.productid = p2.productid " +
			"inner join authors a on p2.authorid = a.authorid " +
			"where ord.status != 5 and ord.dateofissue >= :fromDate and ord.dateofissue <= :toDate " +
			"group by dtl.productid, p.productname, a.firstname, a.lastname order by quantity desc ", nativeQuery = true)
	List<Object[]> findProductLikeFromDateToDate(@Param("fromDate") Date fromDate, @Param("toDate") Date toDate);

	@Query(value = "SELECT dtl.productid, p.productname, CONCAT(a.firstname, a.lastname) as autName, p3.name, sum(dtl.quantity) quantity " +
			"FROM orders ord inner join orderdetail dtl on ord.orderid = dtl.orderid " +
			"inner join product p on dtl.productid = p.productid " +
			"inner join publishers p3 on p.publisherid = p3.publisherid " +
			"inner join productauthor p2 on p.productid = p2.productid " +
			"inner join authors a on p2.authorid = a.authorid " +
			"where ord.status != 5 and ord.dateofissue >= :fromDate " +
			"group by dtl.productid, p.productname, a.firstname, a.lastname order by quantity desc ", nativeQuery = true)
	List<Object[]> findProductLikeFromDate(@Param("fromDate") Date fromDate);

	@Query(value = "SELECT dtl.productid, p.productname, CONCAT(a.firstname, a.lastname) as autName, p3.name, sum(dtl.quantity) quantity " +
			"FROM orders ord inner join orderdetail dtl on ord.orderid = dtl.orderid " +
			"inner join product p on dtl.productid = p.productid " +
			"inner join publishers p3 on p.publisherid = p3.publisherid " +
			"inner join productauthor p2 on p.productid = p2.productid " +
			"inner join authors a on p2.authorid = a.authorid " +
			"where ord.status != 5 and ord.dateofissue <= :toDate " +
			"group by dtl.productid, p.productname, a.firstname, a.lastname order by quantity desc ", nativeQuery = true)
	List<Object[]> findProductLikeToDate(@Param("toDate") Date toDate);

	@Query(value = "SELECT au.authorid, CONCAT(au.firstname, au.lastname) as name, au.othernames, au.birthdate, sum(o.quantity) quantity FROM authors au " +
			"  inner join productauthor p on au.authorid = p.authorid " +
			"  inner join product p2 on p.productid = p2.productid " +
			"  inner join orderdetail o on p2.productid = o.productid" +
			"  inner join orders o2 on o.orderid = o2.orderid " +
			"where o2.status != 5 " +
			"group by au.authorid, au.firstname, au.lastname, au.othernames, au.birthdate order by quantity desc ", nativeQuery = true)
	List<Object[]> findAuthorLike();

	@Query(value = "SELECT au.authorid, CONCAT(au.firstname, au.lastname) as name, au.othernames, au.birthdate, sum(o.quantity) quantity FROM authors au " +
			"  inner join productauthor p on au.authorid = p.authorid " +
			"  inner join product p2 on p.productid = p2.productid " +
			"  inner join orderdetail o on p2.productid = o.productid" +
			"  inner join orders o2 on o.orderid = o2.orderid " +
			"where ord.status != 5 and ord.dateofissue >= :fromDate and ord.dateofissue <= :toDate " +
			"group by au.authorid, au.firstname, au.lastname, au.othernames, au.birthdate order by quantity desc ", nativeQuery = true)
	List<Object[]> findAuthorLikeFromDateToDate(@Param("fromDate") Date fromDate, @Param("toDate") Date toDate);

	@Query(value = "SELECT au.authorid, CONCAT(au.firstname, au.lastname) as name, au.othernames, au.birthdate, sum(o.quantity) quantity FROM authors au " +
			"  inner join productauthor p on au.authorid = p.authorid " +
			"  inner join product p2 on p.productid = p2.productid " +
			"  inner join orderdetail o on p2.productid = o.productid" +
			"  inner join orders o2 on o.orderid = o2.orderid " +
			"where ord.status != 5 and ord.dateofissue >= :fromDate " +
			"group by au.authorid, au.firstname, au.lastname, au.othernames, au.birthdate order by quantity desc ", nativeQuery = true)
	List<Object[]> findAuthorLikeFromDate(@Param("fromDate") Date fromDate);

	@Query(value = "SELECT au.authorid, CONCAT(au.firstname, au.lastname) as name, au.othernames, au.birthdate, sum(o.quantity) quantity FROM authors au " +
			"  inner join productauthor p on au.authorid = p.authorid " +
			"  inner join product p2 on p.productid = p2.productid " +
			"  inner join orderdetail o on p2.productid = o.productid" +
			"  inner join orders o2 on o.orderid = o2.orderid " +
			"where ord.status != 5 and ord.dateofissue <= :toDate " +
			"group by au.authorid, au.firstname, au.lastname, au.othernames, au.birthdate order by quantity desc ", nativeQuery = true)
	List<Object[]> findAuthorLikeToDate(@Param("toDate") Date toDate);

	@Query(value = "select pu.publisherid, pu.name, pu.city, pu.country, sum(o.quantity) quantity from publishers pu " +
			"  inner join product p on pu.publisherid = p.publisherid " +
			"  inner join orderdetail o on p.productid = o.productid " +
			"  inner join orders o2 on o.orderid = o2.orderid " +
			"where o2.status != 5 " +
			"group by pu.publisherid, pu.name, pu.country, pu.city order by quantity desc ", nativeQuery = true)
	List<Object[]> findPublisherLike();

	@Query(value = "select pu.publisherid, pu.name, pu.city, pu.country, sum(o.quantity) quantity from publishers pu " +
			"  inner join product p on pu.publisherid = p.publisherid " +
			"  inner join orderdetail o on p.productid = o.productid " +
			"  inner join orders o2 on o.orderid = o2.orderid " +
			"where ord.status != 5 and ord.dateofissue >= :fromDate and ord.dateofissue <= :toDate " +
			"group by pu.publisherid, pu.name, pu.country, pu.city order by quantity desc ", nativeQuery = true)
	List<Object[]> findPublisherLikeFromDateToDate(@Param("fromDate") Date fromDate, @Param("toDate") Date toDate);

	@Query(value = "select pu.publisherid, pu.name, pu.city, pu.country, sum(o.quantity) quantity from publishers pu " +
			"  inner join product p on pu.publisherid = p.publisherid " +
			"  inner join orderdetail o on p.productid = o.productid " +
			"  inner join orders o2 on o.orderid = o2.orderid " +
			"where ord.status != 5 and ord.dateofissue >= :fromDate  " +
			"group by pu.publisherid, pu.name, pu.country, pu.city order by quantity desc ", nativeQuery = true)
	List<Object[]> findPublisherLikeFromDate(@Param("fromDate") Date fromDate);

	@Query(value = "select pu.publisherid, pu.name, pu.city, pu.country, sum(o.quantity) quantity from publishers pu " +
			"  inner join product p on pu.publisherid = p.publisherid " +
			"  inner join orderdetail o on p.productid = o.productid " +
			"  inner join orders o2 on o.orderid = o2.orderid " +
			"where ord.status != 5 and ord.dateofissue <= :toDate " +
			"group by pu.publisherid, pu.name, pu.country, pu.city order by quantity desc ", nativeQuery = true)
	List<Object[]> findPublisherLikeToDate(@Param("toDate") Date toDate);

}
