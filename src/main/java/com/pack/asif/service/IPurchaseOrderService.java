package com.pack.asif.service;

import java.util.List;

import com.pack.asif.model.PurchaseOrder;

public interface IPurchaseOrderService {

	Integer savePurchaseOrder(PurchaseOrder obs);

	List<PurchaseOrder> getAllPurchaseOrders();

	void deletePurchaseOrder(Integer id);

	PurchaseOrder getOnePurchaseOrder(Integer id);

	void updatePurchaseOrder(PurchaseOrder obs);
	
	List<Object[]> getOrdIdAndOrdCode();

}
