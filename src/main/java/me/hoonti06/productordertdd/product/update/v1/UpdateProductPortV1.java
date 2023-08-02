package me.hoonti06.productordertdd.product.update.v1;

public interface UpdateProductPortV1 {

  void save(UpdateProductV1 product);

  UpdateProductV1 getProduct(long productId);
}
