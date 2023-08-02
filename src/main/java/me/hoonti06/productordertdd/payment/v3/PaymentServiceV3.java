package me.hoonti06.productordertdd.payment.v3;

import me.hoonti06.productordertdd.order.v4.domain.OrderV4;
import me.hoonti06.productordertdd.payment.PaymentRequest;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v3/payments")
public class PaymentServiceV3 {

  private final PaymentPortV3 paymentPort;

  PaymentServiceV3(PaymentPortV3 paymentPort) {
    this.paymentPort = paymentPort;
  }

  @PostMapping
  @Transactional
  public void payment(@RequestBody PaymentRequest request) {
    OrderV4 order = paymentPort.getOrder(request.orderId());
    final PaymentV3 payment = new PaymentV3(order, request.cardNumber());
    paymentPort.pay(order.getTotalPrice(), payment.getCardNumber());
    paymentPort.save(payment);

  }
}
