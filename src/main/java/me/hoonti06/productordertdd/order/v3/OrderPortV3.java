package me.hoonti06.productordertdd.order.v3;

import me.hoonti06.productordertdd.product.z.domain.Product;

public interface OrderPortV3 {

  Product getProductById(Long productId);

  void save(OrderV3 order);
}
