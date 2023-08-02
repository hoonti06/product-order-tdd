package me.hoonti06.productordertdd.order.v2;

import me.hoonti06.productordertdd.order.CreateOrderRequest;
import me.hoonti06.productordertdd.product.z.domain.Product;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceV2 {

  private final OrderPortV2 orderPort;

  OrderServiceV2(OrderPortV2 orderPort) {
    this.orderPort = orderPort;
  }

  public void createOrder(CreateOrderRequest request) {
    Product product = orderPort.getProductById(request.productId());
    OrderV2 order = new OrderV2(product, request.quantity());
    orderPort.save(order);
  }

}
