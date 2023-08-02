package me.hoonti06.productordertdd.payment.v3;

public interface PaymentGatewayV3 {

  void excuete(int totalPrice, String cardNumber);
}
