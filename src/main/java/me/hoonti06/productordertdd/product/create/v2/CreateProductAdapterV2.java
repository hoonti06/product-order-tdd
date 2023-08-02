package me.hoonti06.productordertdd.product.create.v2;

import org.springframework.stereotype.Component;

@Component
class CreateProductAdapterV2 implements CreateProductPortV2 {

  private final CreateProductRepositoryV2 productRepository;

  CreateProductAdapterV2(CreateProductRepositoryV2 productRepository) {
    this.productRepository = productRepository;
  }

  @Override
  public void save(CreateProductV2 product) {
    productRepository.save(product);

  }

}
