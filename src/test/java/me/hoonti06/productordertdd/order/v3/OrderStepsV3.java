package me.hoonti06.productordertdd.order.v3;

import me.hoonti06.productordertdd.order.CreateOrderRequest;

public class OrderStepsV3 {
  public static CreateOrderRequest 상품주문요청_생성() {
    final Long productId = 1L;
    final int quantity = 2;
    return new CreateOrderRequest(productId, quantity);
  }

}
