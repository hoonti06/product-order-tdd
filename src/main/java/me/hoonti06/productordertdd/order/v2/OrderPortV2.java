package me.hoonti06.productordertdd.order.v2;

import me.hoonti06.productordertdd.product.z.domain.Product;

public interface OrderPortV2 {

  Product getProductById(Long productId);

  void save(OrderV2 order);
}
