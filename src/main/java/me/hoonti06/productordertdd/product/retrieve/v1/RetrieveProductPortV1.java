package me.hoonti06.productordertdd.product.retrieve.v1;

public interface RetrieveProductPortV1 {

  void save(RetrieveProductV1 product);

  RetrieveProductV1 getProduct(long productId);
}
