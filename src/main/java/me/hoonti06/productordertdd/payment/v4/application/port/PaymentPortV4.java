package me.hoonti06.productordertdd.payment.v4.application.port;

import me.hoonti06.productordertdd.order.v4.domain.OrderV4;
import me.hoonti06.productordertdd.payment.v4.domain.PaymentV4;

public interface PaymentPortV4 {

  OrderV4 getOrder(Long orderId);

  void pay(int totalPrice, String cardNumber);

  void save(PaymentV4 payment);
}
