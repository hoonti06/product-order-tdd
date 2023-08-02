package me.hoonti06.productordertdd.product.update.v2;

import java.util.NoSuchElementException;
import org.springframework.stereotype.Component;

@Component
class UpdateProductAdapterV2 implements UpdateProductPortV2 {

  private final UpdateProductRepositoryV2 productRepository;

  UpdateProductAdapterV2(UpdateProductRepositoryV2 productRepository) {
    this.productRepository = productRepository;
  }

  @Override
  public void save(UpdateProductV2 product) {
    productRepository.save(product);

  }

  @Override
  public UpdateProductV2 getProduct(long productId) {
    return productRepository.findById(productId)
        .orElseThrow(() -> new NoSuchElementException("상품이 존재하지 않습니다."));
  }

}
