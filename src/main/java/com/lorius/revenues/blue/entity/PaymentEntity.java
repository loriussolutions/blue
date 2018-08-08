package com.lorius.revenues.blue.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import com.lorius.revenues.blue.entity.type.PaymentStatus;

@Entity
@Table(name = "BLUE_PAYMENT", schema = "BL")
public class PaymentEntity extends AbstractEntity {

	@Column(name = "reference", nullable = false)
	private String reference;

	@Column(name = "issueDate", nullable = false)
	private LocalDateTime issueDate;

	@Column(name = "dueDate", nullable = false)
	private LocalDate dueDate;

	@Column(name = "comments")
	private String comments;

	@Column(name = "amount", nullable = false)
	private BigDecimal amount;

	@Enumerated(EnumType.STRING)
	@Column(name = "status", nullable = true)
	private PaymentStatus status;

	public PaymentEntity() {
		status = PaymentStatus.OPEN;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public LocalDateTime getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(LocalDateTime issueDate) {
		this.issueDate = issueDate;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public PaymentStatus getStatus() {
		return status;
	}

	public void setStatus(PaymentStatus status) {
		this.status = status;
	}
}
