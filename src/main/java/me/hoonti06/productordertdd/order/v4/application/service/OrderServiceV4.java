package me.hoonti06.productordertdd.order.v4.application.service;

import javax.transaction.Transactional;
import me.hoonti06.productordertdd.order.CreateOrderRequest;
import me.hoonti06.productordertdd.order.v4.domain.OrderV4;
import me.hoonti06.productordertdd.order.v4.application.port.OrderPortV4;
import me.hoonti06.productordertdd.product.z.domain.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v4/orders")
public class OrderServiceV4 {

  private final OrderPortV4 orderPort;

  OrderServiceV4(OrderPortV4 orderPort) {
    this.orderPort = orderPort;
  }

  @PostMapping
  @Transactional
  public ResponseEntity<Void> createOrder(@RequestBody final CreateOrderRequest request) {
    Product product = orderPort.getProductById(request.productId());
    OrderV4 order = new OrderV4(product, request.quantity());

    orderPort.save(order);

    return ResponseEntity.status(HttpStatus.CREATED).build();
  }

}
