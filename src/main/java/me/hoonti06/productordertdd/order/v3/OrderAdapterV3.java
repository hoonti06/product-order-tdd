package me.hoonti06.productordertdd.order.v3;

import java.util.NoSuchElementException;
import me.hoonti06.productordertdd.product.z.domain.Product;
import me.hoonti06.productordertdd.product.z.adapter.ProductRepository;
import org.springframework.stereotype.Component;

@Component
class OrderAdapterV3 implements OrderPortV3 {

  private final OrderRepositoryV3 orderRepository;
  private final ProductRepository productRepository;

  public OrderAdapterV3(OrderRepositoryV3 orderRepository, ProductRepository productRepository) {
    this.orderRepository = orderRepository;
    this.productRepository = productRepository;
  }

  public Product getProductById(Long productId) {
    return productRepository.findById(productId)
        .orElseThrow(() -> new NoSuchElementException("상품이 존재하지 않습니다."));
  }

  @Override
  public void save(OrderV3 order) {
    orderRepository.save(order);
  }

}
