package me.hoonti06.productordertdd.product.z.applicaiton.port;

import me.hoonti06.productordertdd.product.z.domain.Product;

public interface ProductPort {

  void save(Product product);

  Product getProduct(Long productId);
}
