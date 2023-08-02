package me.hoonti06.productordertdd.product.retrieve.v4;

import java.util.NoSuchElementException;
import org.springframework.stereotype.Component;

@Component
class RetrieveProductAdapterV4 implements RetrieveProductPortV4 {

  private final RetrieveProductRepositoryV4 productRepository;

  RetrieveProductAdapterV4(RetrieveProductRepositoryV4 productRepository) {
    this.productRepository = productRepository;
  }

  @Override
  public void save(RetrieveProductV4 product) {
    productRepository.save(product);

  }

  @Override
  public RetrieveProductV4 getProduct(long productId) {
    return productRepository.findById(productId)
        .orElseThrow(() -> new NoSuchElementException("상품이 존재하지 않습니다."));
  }

}
