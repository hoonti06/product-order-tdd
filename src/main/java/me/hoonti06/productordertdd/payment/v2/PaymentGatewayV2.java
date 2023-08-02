package me.hoonti06.productordertdd.payment.v2;

public interface PaymentGatewayV2 {

  void excuete(int totalPrice, String cardNumber);
}
