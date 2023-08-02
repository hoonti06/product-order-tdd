package me.hoonti06.productordertdd.payment.v4.adapter;

import me.hoonti06.productordertdd.payment.v4.domain.PaymentV4;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepositoryV4 extends JpaRepository<PaymentV4, Long> {
}
