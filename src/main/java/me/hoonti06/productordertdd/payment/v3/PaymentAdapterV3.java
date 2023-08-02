package me.hoonti06.productordertdd.payment.v3;

import java.util.NoSuchElementException;
import me.hoonti06.productordertdd.order.v4.adapter.OrderRepositoryV4;
import me.hoonti06.productordertdd.order.v4.domain.OrderV4;
import org.springframework.stereotype.Component;

@Component
public class PaymentAdapterV3 implements PaymentPortV3 {

  private final PaymentGatewayV3 paymentGateway;
  private final PaymentRepositoryV3 paymentRepository;
  private final OrderRepositoryV4 orderRepository;

  public PaymentAdapterV3(PaymentGatewayV3 paymentGateway, PaymentRepositoryV3 paymentRepository,
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
  public void save(PaymentV3 payment) {
    paymentRepository.save(payment);
  }
}
