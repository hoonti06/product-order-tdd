package me.hoonti06.productordertdd.product.update.v4;

import java.util.NoSuchElementException;
import org.springframework.stereotype.Component;

@Component
class UpdateProductAdapterV4 implements UpdateProductPortV4 {

  private final UpdateProductRepositoryV4 productRepository;

  UpdateProductAdapterV4(UpdateProductRepositoryV4 productRepository) {
    this.productRepository = productRepository;
  }

  @Override
  public void save(UpdateProductV4 product) {
    productRepository.save(product);

  }

  @Override
  public UpdateProductV4 getProduct(Long productId) {
    return productRepository.findById(productId)
        .orElseThrow(() -> new NoSuchElementException("상품이 존재하지 않습니다."));
  }
}
