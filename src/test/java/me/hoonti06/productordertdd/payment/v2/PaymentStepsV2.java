package me.hoonti06.productordertdd.payment.v2;

import me.hoonti06.productordertdd.payment.PaymentRequest;

public class PaymentStepsV2 {

  public static PaymentRequest 주문결제요청_생성() {
    final Long orderId = 1L;
    final String cardNumber = "1234-1234-1234-1234";
    return new PaymentRequest(orderId, cardNumber);
  }
}
