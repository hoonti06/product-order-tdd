package me.hoonti06.productordertdd.payment;

import org.springframework.util.Assert;

public record PaymentRequest(Long orderId, String cardNumber) {

  public PaymentRequest {
    Assert.notNull(orderId, "주문 ID는 필수입니다.");
    Assert.hasText(cardNumber, "카드번호는 필수입니다.");
  }

}
