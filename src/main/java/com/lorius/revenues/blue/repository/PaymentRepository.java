package com.lorius.revenues.blue.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lorius.revenues.blue.entity.PaymentEntity;

public interface PaymentRepository extends JpaRepository<PaymentEntity,String> {
	
    public List<PaymentEntity> findAllByOrderByIssueDateDesc();
}
