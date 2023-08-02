package me.hoonti06.productordertdd.order.v4.adapter;

import java.util.NoSuchElementException;
import me.hoonti06.productordertdd.order.v4.domain.OrderV4;
import me.hoonti06.productordertdd.order.v4.application.port.OrderPortV4;
import me.hoonti06.productordertdd.product.z.domain.Product;
import me.hoonti06.productordertdd.product.z.adapter.ProductRepository;
import org.springframework.stereotype.Component;

@Component
class OrderAdapterV4 implements OrderPortV4 {

  private final OrderRepositoryV4 orderRepository;
  private final ProductRepository productRepository;

  public OrderAdapterV4(OrderRepositoryV4 orderRepository, ProductRepository productRepository) {
    this.orderRepository = orderRepository;
    this.productRepository = productRepository;
  }

  public Product getProductById(Long productId) {
    return productRepository.findById(productId)
        .orElseThrow(() -> new NoSuchElementException("상품이 존재하지 않습니다."));
  }

  @Override
  public void save(OrderV4 order) {
    orderRepository.save(order);
  }

}
