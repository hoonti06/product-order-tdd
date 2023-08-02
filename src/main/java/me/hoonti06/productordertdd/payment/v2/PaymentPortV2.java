package me.hoonti06.productordertdd.payment.v2;

import me.hoonti06.productordertdd.order.v4.domain.OrderV4;

public interface PaymentPortV2 {

  OrderV4 getOrder(Long orderId);

  void pay(int totalPrice, String cardNumber);

  void save(PaymentV2 payment);
}
