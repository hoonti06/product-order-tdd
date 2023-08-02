package me.hoonti06.productordertdd.payment.v4.adapter;

import org.springframework.stereotype.Component;

@Component
public class ConsolePaymentGatewayV4 implements PaymentGatewayV4 {

  @Override
  public void excuete(int totalPrice, String cardNumber) {
    System.out.println("결제 완료");
  }
}
