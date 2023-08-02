package me.hoonti06.productordertdd.product.retrieve.v1;

import java.util.NoSuchElementException;
import org.springframework.stereotype.Component;

@Component
class RetrieveProductAdapterV1 implements RetrieveProductPortV1 {

  private final RetrieveProductRepositoryV1 productRepository;

  RetrieveProductAdapterV1(RetrieveProductRepositoryV1 productRepository) {
    this.productRepository = productRepository;
  }

  @Override
  public void save(RetrieveProductV1 product) {
    productRepository.save(product);

  }

  @Override
  public RetrieveProductV1 getProduct(long productId) {
    return productRepository.findById(productId)
        .orElseThrow(() -> new NoSuchElementException("상품이 존재하지 않습니다."));
  }

}
