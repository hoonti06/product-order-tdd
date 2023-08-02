package me.hoonti06.productordertdd.payment.v4.application.service;

import me.hoonti06.productordertdd.order.v4.domain.OrderV4;
import me.hoonti06.productordertdd.payment.PaymentRequest;
import me.hoonti06.productordertdd.payment.v4.application.port.PaymentPortV4;
import me.hoonti06.productordertdd.payment.v4.domain.PaymentV4;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v4/payments")
public class PaymentServiceV4 {

  private final PaymentPortV4 paymentPort;

  PaymentServiceV4(PaymentPortV4 paymentPort) {
    this.paymentPort = paymentPort;
  }

  @PostMapping
  @Transactional
  public void payment(@RequestBody PaymentRequest request) {
    OrderV4 order = paymentPort.getOrder(request.orderId());
    final PaymentV4 payment = new PaymentV4(order, request.cardNumber());
    paymentPort.pay(order.getTotalPrice(), payment.getCardNumber());
    paymentPort.save(payment);

  }
}
