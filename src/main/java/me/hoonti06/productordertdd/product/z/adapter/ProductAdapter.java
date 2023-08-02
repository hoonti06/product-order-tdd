package me.hoonti06.productordertdd.product.z.adapter;

import java.util.NoSuchElementException;
import me.hoonti06.productordertdd.product.z.domain.Product;
import me.hoonti06.productordertdd.product.z.applicaiton.port.ProductPort;
import org.springframework.stereotype.Component;

@Component
class ProductAdapter implements ProductPort {

  private final ProductRepository productRepository;

  ProductAdapter(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  @Override
  public void save(Product product) {
    productRepository.save(product);

  }

  @Override
  public Product getProduct(Long productId) {
    return productRepository.findById(productId)
        .orElseThrow(() -> new NoSuchElementException("상품이 존재하지 않습니다."));
  }
}
