package me.hoonti06.productordertdd.payment.v2;

import lombok.extern.slf4j.Slf4j;
import me.hoonti06.productordertdd.order.v4.domain.OrderV4;
import me.hoonti06.productordertdd.payment.PaymentRequest;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Component
public class PaymentServiceV2 {

  private final PaymentPortV2 paymentPort;

  PaymentServiceV2(PaymentPortV2 paymentPort) {
    this.paymentPort = paymentPort;
  }

  @Transactional
  public void payment(PaymentRequest request) {
    OrderV4 order = paymentPort.getOrder(request.orderId());
    final PaymentV2 payment = new PaymentV2(order, request.cardNumber());

    paymentPort.pay(order.getTotalPrice(), payment.getCardNumber());
    paymentPort.save(payment);

  }
}
