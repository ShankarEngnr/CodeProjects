//package com.example.paymentservice.entity;
//
//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.Table;
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//@Entity
//@Table(name = "payments")
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//@Builder
//public class PaymentEntity {
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Long id;
//
////	@Column(nullable = false, unique = true)
////	private String transactionId; // Unique Payment ID
//
//	@Column(nullable = false)
//	private String userId; // User making the payment
//
////	@Column(nullable = false)
////	private Double amount; // Payment Amount
////
////	@Column(nullable = false)
////	private String status; // Payment Status (PENDING, SUCCESS, FAILED)
////
////	@Column(nullable = false)
////	private LocalDateTime createdAt;
//}
