package me.hoonti06.productordertdd.product.create.v4;

import org.springframework.stereotype.Component;

@Component
class CreateProductAdapterV4 implements CreateProductPortV4 {

  private final CreateProductRepositoryV4 productRepository;

  CreateProductAdapterV4(CreateProductRepositoryV4 productRepository) {
    this.productRepository = productRepository;
  }

  @Override
  public void save(CreateProductV4 product) {
    productRepository.save(product);

  }

}
