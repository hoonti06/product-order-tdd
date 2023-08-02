package me.hoonti06.productordertdd.product.retrieve.v4;

public interface RetrieveProductPortV4 {

  void save(RetrieveProductV4 product);

  RetrieveProductV4 getProduct(long productId);
}
