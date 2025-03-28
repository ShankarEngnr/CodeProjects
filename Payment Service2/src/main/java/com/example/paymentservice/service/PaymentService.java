package com.example.paymentservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.paymentservice.client.OtpClient;

@Service
public class PaymentService {

	@Autowired
	private OtpClient otpClient;

	public String initiatePayment(String userId) {
		return otpClient.generateOtp(userId);
	}

	public boolean processPayment(String userId, String otp) {
		return otpClient.validateOtp(userId, otp);
	}

}
