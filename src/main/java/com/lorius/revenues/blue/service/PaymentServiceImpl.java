package com.lorius.revenues.blue.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lorius.revenues.blue.entity.PaymentEntity;
import com.lorius.revenues.blue.entity.type.PaymentStatus;
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

	public void updatePaymentStatus() {
		LocalDate currentDate = LocalDate.now();
		LocalDate defaultDueDate = LocalDate.now();
		defaultDueDate = LocalDate.of(currentDate.getYear(), currentDate.getMonth(), 8);

		List<PaymentEntity> payments = findAll();
		for (PaymentEntity paymentEntity : payments) {

			if (paymentEntity.getStatus() == PaymentStatus.OPEN) {
				if (paymentEntity.getDueDate().getYear() == currentDate.getYear()) {
					if (paymentEntity.getDueDate().isAfter(defaultDueDate)) {
						paymentEntity.setStatus(PaymentStatus.EXPIRED);
						paymentRepository.save(paymentEntity);
					}
				}
			}
		}	
	}

}
