package me.hoonti06.productordertdd.payment.v3;

import me.hoonti06.productordertdd.order.v4.domain.OrderV4;
import org.springframework.util.Assert;

public class PaymentV3 {

  private Long id;
  private final OrderV4 order;
  private final String cardNumber;

  public PaymentV3(final OrderV4 order, final String cardNumber) {
    Assert.notNull(order, "주문은 필수입니다.");
    Assert.hasText(cardNumber, "카드번호는 필수입니다.");
    this.order = order;
    this.cardNumber = cardNumber;
  }

  public void assignId(long id) {
    this.id = id;
  }

  public Long getId() {
    return this.id;
  }

  public String getCardNumber() {
    return cardNumber;
  }
}
