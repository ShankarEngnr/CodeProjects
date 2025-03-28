package com.example.paymentservice.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.paymentservice.service.PaymentService;

@RestController
@RequestMapping("/payment")
public class PaymentController {

//	@Autowired
//	private PaymentService paymentService;

	private final PaymentService paymentService;

	public PaymentController(PaymentService paymentService) { // Constructor injection
		this.paymentService = paymentService;
	}

	@PostMapping("/initiate/{userId}")
	public String initiatePayment(@PathVariable(value = "userId") String userId) {
		return "OTP Sent: " + paymentService.initiatePayment(userId);
	}

	@PostMapping("/confirm/{userId}/{otp}")

	public String confirmPayment(@PathVariable(value = "userId") String userId,
			@PathVariable(value = "otp") String otp) {
		if (paymentService.processPayment(userId, otp)) {
			return "Payment Successful!";
		}
		return "Invalid OTP!";
	}
}
