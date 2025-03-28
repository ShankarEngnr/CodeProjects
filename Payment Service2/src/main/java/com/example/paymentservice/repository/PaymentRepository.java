//package com.example.paymentservice.repository;
//
//import java.util.Optional;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;
//
//import com.example.paymentservice.entity.PaymentEntity;
//
//@Repository
//public interface PaymentRepository extends JpaRepository<PaymentEntity, Long> {
//
//	Optional<PaymentEntity> findByTransactionId(String transactionId);
//
//	Optional<PaymentEntity> findByUserIdAndStatus(String userId, String status);
//}
