package com.example.paymentservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "otpService", url = "http://localhost:8081/otp")
public interface OtpClient {

	@PostMapping("/generate/{userId}")
	String generateOtp(@PathVariable(value = "userId") String userId);

	@PostMapping("/validate/{userId}/{otp}")
	boolean validateOtp(@PathVariable(value = "userId") String userId, @PathVariable(value = "otp") String otp);
}
