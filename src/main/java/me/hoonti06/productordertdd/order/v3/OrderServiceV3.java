package me.hoonti06.productordertdd.order.v3;

import me.hoonti06.productordertdd.order.CreateOrderRequest;
import me.hoonti06.productordertdd.product.z.domain.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v3/orders")
class OrderServiceV3 {

  private final OrderPortV3 orderPort;

  OrderServiceV3(OrderPortV3 orderPort) {
    this.orderPort = orderPort;
  }

  @PostMapping
  public ResponseEntity<Void> createOrder(@RequestBody final CreateOrderRequest request) {
    Product product = orderPort.getProductById(request.productId());
    OrderV3 order = new OrderV3(product, request.quantity());

    orderPort.save(order);

    return ResponseEntity.status(HttpStatus.CREATED).build();
  }

}
