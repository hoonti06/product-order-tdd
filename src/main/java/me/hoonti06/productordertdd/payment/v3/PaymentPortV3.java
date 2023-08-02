package me.hoonti06.productordertdd.payment.v3;

import me.hoonti06.productordertdd.order.v4.domain.OrderV4;

public interface PaymentPortV3 {

  OrderV4 getOrder(Long orderId);

  void pay(int totalPrice, String cardNumber);

  void save(PaymentV3 payment);
}
