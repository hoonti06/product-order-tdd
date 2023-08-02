package me.hoonti06.productordertdd.order.v4.application.port;

import me.hoonti06.productordertdd.order.v4.domain.OrderV4;
import me.hoonti06.productordertdd.product.z.domain.Product;

public interface OrderPortV4 {

  Product getProductById(Long productId);

  void save(OrderV4 order);
}
