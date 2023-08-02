package me.hoonti06.productordertdd.product.update.v4;

public interface UpdateProductPortV4 {

  void save(UpdateProductV4 product);

  UpdateProductV4 getProduct(Long productId);
}
