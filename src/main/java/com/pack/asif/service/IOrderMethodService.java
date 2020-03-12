package com.pack.asif.service;

import java.util.List;

import com.pack.asif.model.OrderMethod;

public interface IOrderMethodService {

	Integer saveOrderMethod(OrderMethod cob);

	List<OrderMethod> getAllOrderMethods();

	public void deleteOrderMethod(Integer id);

	OrderMethod getOneOrderMethod(Integer id);

	void updateOrderMethod(OrderMethod cob);

	List<Object[]> getOrdIdAndOrdCode(String mode);
}
