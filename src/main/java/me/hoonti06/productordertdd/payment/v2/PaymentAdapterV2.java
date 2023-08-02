package me.hoonti06.productordertdd.payment.v2;

import java.util.NoSuchElementException;
import lombok.extern.slf4j.Slf4j;
import me.hoonti06.productordertdd.order.v4.adapter.OrderRepositoryV4;
import me.hoonti06.productordertdd.order.v4.domain.OrderV4;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class PaymentAdapterV2 implements PaymentPortV2 {

  private final PaymentGatewayV2 paymentGateway;
  private final PaymentRepositoryV2 paymentRepository;
  private final OrderRepositoryV4 orderRepository;

  public PaymentAdapterV2(PaymentGatewayV2 paymentGateway, PaymentRepositoryV2 paymentRepository,
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
  public void save(PaymentV2 payment) {
    paymentRepository.save(payment);
  }
}
