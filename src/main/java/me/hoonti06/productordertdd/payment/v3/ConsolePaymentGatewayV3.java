package me.hoonti06.productordertdd.payment.v3;

import org.springframework.stereotype.Component;

@Component
public class ConsolePaymentGatewayV3 implements PaymentGatewayV3 {

  @Override
  public void excuete(int totalPrice, String cardNumber) {
    System.out.println("결제 완료");
  }
}
