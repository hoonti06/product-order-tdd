package me.hoonti06.productordertdd.payment.v4.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.hoonti06.productordertdd.order.v4.domain.OrderV4;
import org.springframework.util.Assert;

@Entity
@Table(name = "payments")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PaymentV4 {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @OneToOne
  private OrderV4 order;
  private String cardNumber;

  public PaymentV4(final OrderV4 order, final String cardNumber) {
    Assert.notNull(order, "주문은 필수입니다.");
    Assert.hasText(cardNumber, "카드번호는 필수입니다.");
    this.order = order;
    this.cardNumber = cardNumber;
  }

}
