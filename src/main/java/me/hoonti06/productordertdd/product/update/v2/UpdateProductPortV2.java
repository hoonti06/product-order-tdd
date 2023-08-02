package me.hoonti06.productordertdd.product.update.v2;

public interface UpdateProductPortV2 {

  void save(UpdateProductV2 product);

  UpdateProductV2 getProduct(long productId);
}
