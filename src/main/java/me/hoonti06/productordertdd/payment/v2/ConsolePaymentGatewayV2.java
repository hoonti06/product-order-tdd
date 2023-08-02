package me.hoonti06.productordertdd.payment.v2;

import org.springframework.stereotype.Component;

@Component
public class ConsolePaymentGatewayV2 implements PaymentGatewayV2 {

  @Override
  public void excuete(int totalPrice, String cardNumber) {
    System.out.println("결제 완료");
  }
}
