package com.lorius.revenues.blue.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lorius.revenues.blue.entity.PaymentEntity;
import com.lorius.revenues.blue.repository.PaymentRepository;

@Service
public class PaymentServiceImpl implements PaymentService {

	@Autowired
	private PaymentRepository paymentRepository;

	public List<PaymentEntity> findAll() {
		return paymentRepository.findAllByOrderByIssueDateDesc();
	}

	public void save(PaymentEntity paymentEntity) {
		paymentRepository.save(paymentEntity);
	}

}
