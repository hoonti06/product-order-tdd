package me.hoonti06.productordertdd.payment.v4.adapter;

import java.util.NoSuchElementException;
import me.hoonti06.productordertdd.order.v4.adapter.OrderRepositoryV4;
import me.hoonti06.productordertdd.order.v4.domain.OrderV4;
import me.hoonti06.productordertdd.payment.v4.application.port.PaymentPortV4;
import me.hoonti06.productordertdd.payment.v4.domain.PaymentV4;
import org.springframework.stereotype.Component;

@Component
public class PaymentAdapterV4 implements PaymentPortV4 {

  private final PaymentGatewayV4 paymentGateway;
  private final PaymentRepositoryV4 paymentRepository;
  private final OrderRepositoryV4 orderRepository;

  public PaymentAdapterV4(PaymentGatewayV4 paymentGateway, PaymentRepositoryV4 paymentRepository,
      OrderRepositoryV4 orderRepository) {
    this.paymentGateway = paymentGateway;
    this.paymentRepository = paymentRepository;
    this.orderRepository = orderRepository;
  }

  @Override
  public OrderV4 getOrder(Long orderId) {
    return orderRepository.findById(orderId).orElseThrow(() -> new NoSuchElementException("주문이 존재하지 않습니다."));
  }

  @Override
  public void pay(int totalPrice, String cardNumber) {
    paymentGateway.excuete(totalPrice, cardNumber);
  }

  @Override
  public void save(PaymentV4 payment) {
    paymentRepository.save(payment);
  }
}
