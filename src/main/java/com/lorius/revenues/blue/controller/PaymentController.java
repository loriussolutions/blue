package com.lorius.revenues.blue.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.lorius.revenues.blue.entity.PaymentEntity;
import com.lorius.revenues.blue.service.PaymentService;

@Controller
public class PaymentController {

	@Autowired
	private PaymentService paymentService;

	/**
	 * Request mapping for user
	 */
	@RequestMapping(value = { "/payment", "/payment/index" }, method = RequestMethod.GET)
	public String getAccount(Model model) {
		// ModelAndView mv = new ModelAndView("/payment/index");

//		PaymentEntity payment = new PaymentEntity();
//		payment.setAmount(new BigDecimal("300"));
//		payment.setDueDate(LocalDate.now());
//		payment.setIssueDate(LocalDateTime.now());
//		payment.setReference(LocalDateTime.now().toString());
//		paymentService.save(payment);
		List<PaymentEntity> payments = paymentService.findAll();

		model.addAttribute("payments", payments);

		return "/payment/index";
	}

	@RequestMapping(value = { "/payment/updload" }, method = RequestMethod.POST)
	public String uploadPaymentProof(Model model, @RequestParam("file") MultipartFile file) {
		// ModelAndView mv = new ModelAndView("/payment/index");

//		PaymentEntity payment = new PaymentEntity();
//		payment.setAmount(new BigDecimal("300"));
//		payment.setDueDate(LocalDate.now());
//		payment.setIssueDate(LocalDateTime.now());
//		payment.setReference(LocalDateTime.now().toString());
//		paymentService.save(payment);
		List<PaymentEntity> payments = paymentService.findAll();

		model.addAttribute("payments", payments);

		return "/payment/index";
	}

	@RequestMapping(value = { "/payment/cron/update" }, method = RequestMethod.GET)
	public void cronJobUpdate(Model model) {
		paymentService.updatePaymentStatus();
		
		System.out.println("Update Payment Status");
		
	}

}
