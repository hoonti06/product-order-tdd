package me.hoonti06.productordertdd.product.create.v3;

import org.springframework.stereotype.Component;

@Component
class CreateProductAdapterV3 implements CreateProductPortV3 {

  private final CreateProductRepositoryV3 productRepository;

  CreateProductAdapterV3(CreateProductRepositoryV3 productRepository) {
    this.productRepository = productRepository;
  }

  @Override
  public void save(CreateProductV3 product) {
    productRepository.save(product);

  }

}
