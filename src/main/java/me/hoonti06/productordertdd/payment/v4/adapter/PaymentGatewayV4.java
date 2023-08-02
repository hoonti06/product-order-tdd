package me.hoonti06.productordertdd.payment.v4.adapter;

public interface PaymentGatewayV4 {

  void excuete(int totalPrice, String cardNumber);
}
