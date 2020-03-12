package com.pack.asif.dao;

import java.util.List;

import com.pack.asif.model.OrderMethod;

public interface IOrderMethodDao {

	Integer saveOrderMethod(OrderMethod cob);

	List<OrderMethod> getAllOrderMethods();

	public void deleteOrderMethod(Integer id);

	OrderMethod getOneOrderMethod(Integer id);

	void updateOrderMethod(OrderMethod cob);

	List<Object[]> getOrdIdAndOrdCode(String mode);
}
