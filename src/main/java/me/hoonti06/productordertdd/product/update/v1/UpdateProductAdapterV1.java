package me.hoonti06.productordertdd.product.update.v1;

import java.util.NoSuchElementException;
import org.springframework.stereotype.Component;

@Component
class UpdateProductAdapterV1 implements UpdateProductPortV1 {

  private final UpdateProductRepositoryV1 productRepository;

  UpdateProductAdapterV1(UpdateProductRepositoryV1 productRepository) {
    this.productRepository = productRepository;
  }

  @Override
  public void save(UpdateProductV1 product) {
    productRepository.save(product);

  }

  @Override
  public UpdateProductV1 getProduct(long productId) {
    return productRepository.findById(productId)
        .orElseThrow(() -> new NoSuchElementException("상품이 존재하지 않습니다."));
  }

}
