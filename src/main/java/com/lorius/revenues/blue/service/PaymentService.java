package com.lorius.revenues.blue.service;

import java.util.List;

import com.lorius.revenues.blue.entity.PaymentEntity;

public interface PaymentService {

	List<PaymentEntity> findAll();
	
	void save(PaymentEntity paymentEntity);
}
