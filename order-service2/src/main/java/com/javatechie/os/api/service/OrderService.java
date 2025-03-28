package com.javatechie.os.api.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.javatechie.os.api.common.Payment;
import com.javatechie.os.api.common.TransactionRequest;
import com.javatechie.os.api.common.TransactionResponse;
import com.javatechie.os.api.entity.Order;
import com.javatechie.os.api.repository.OrderRepository;

@Service
@RefreshScope
public class OrderService {

	private Logger logger = LoggerFactory.getLogger(OrderService.class);

	@Autowired
	private OrderRepository repository;

	@Autowired
	@Lazy
	private RestTemplate template;

	@Value("${microservice.payment-service.endpoints.endpoint.uri}")
	private String ENDPOINT_URL;

	public TransactionResponse saveOrder(TransactionRequest request) throws JsonProcessingException {
		String response = "";
		Order order = request.getOrder();
		Payment payment = request.getPayment();
		payment.setOrderId(order.getId());
		payment.setAmount(order.getPrice());

		logger.info("OrderService request : {}", new ObjectMapper().writeValueAsString(request));
		// rest call
		Payment paymentResponse = template.postForObject(ENDPOINT_URL, payment, Payment.class);
		logger.info("Payment-Service response from Order Rest call : {}",
				new ObjectMapper().writeValueAsString(paymentResponse));

		response = paymentResponse.getPaymentStatus().equals("success")
				? "payment processing successful and order placed"
				: "there is a failure in payment api , order added to cart";
		repository.save(order);
		return new TransactionResponse(order, paymentResponse.getAmount(), paymentResponse.getTransactionId(),
				response);
	}
}
