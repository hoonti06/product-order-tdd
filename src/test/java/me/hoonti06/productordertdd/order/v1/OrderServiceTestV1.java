package me.hoonti06.productordertdd.order.v1;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import me.hoonti06.productordertdd.product.z.domain.DiscountPolicy;
import me.hoonti06.productordertdd.product.z.domain.Product;
import me.hoonti06.productordertdd.product.z.adapter.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

public class OrderServiceTestV1 {

  private OrderService orderService;

  @BeforeEach
  void setUp() {

    OrderRepository orderRepository = new OrderRepository();
    OrderPort orderPort = new OrderPort() {
      @Override
      public Product getProductById(Long productId) {
        return new Product("상품명", 1000, DiscountPolicy.NONE);
      }

      @Override
      public void save(Order order) {
        orderRepository.save(order);
      }
    };
    orderService = new OrderService(orderPort);
  }

  @Test
  void 상품주문() {
    final Long productId = 1L;
    final int quantity = 2;
    CreateOrderRequest request = new CreateOrderRequest(productId, quantity);

    orderService.createOrder(request);
  }


  private record CreateOrderRequest(Long productId, int quantity) {
    private CreateOrderRequest {
      Assert.notNull(productId, "상품 ID는 필수입니다.");
      Assert.isTrue(quantity > 0, "수량은 0보다 커야 합니다.");
    }
  }

  private class OrderService {

    private final OrderPort orderPort;

    private OrderService(OrderPort orderPort) {
      this.orderPort = orderPort;
    }

    public void createOrder(CreateOrderRequest request) {
      Product product = orderPort.getProductById(request.productId());
      Order order = new Order(product, request.quantity());
      orderPort.save(order);
    }

  }
  private class Order {

    private Long id;
    private final Product product;
    private final int quantity;

    public Order(final Product product, final int quantity) {
      Assert.notNull(product, "상품은 필수입니다.");
      Assert.isTrue(quantity > 0, "수량은 0보다 커야 합니다.");
      this.product = product;
      this.quantity = quantity;
    }

    public void assignId(Long id) {
      this.id = id;
    }

    public Long getId() {
      return id;
    }
  }

  private interface OrderPort {
    Product getProductById(Long productId);

    void save(Order order);
  }

  private class OrderAdapter implements OrderPort {
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    public OrderAdapter(OrderRepository orderRepository, ProductRepository productRepository) {
      this.orderRepository = orderRepository;
      this.productRepository = productRepository;
    }

    public Product getProductById(Long productId) {
      return productRepository.findById(productId)
          .orElseThrow(() -> new NoSuchElementException("상품이 존재하지 않습니다."));
    }

    @Override
    public void save(Order order) {
      orderRepository.save(order);
    }

  }

  private class OrderRepository {
    private final Map<Long, Order> persistence = new HashMap<>();
    private Long sequence = 0L;


    public void save(Order order) {
      order.assignId(++sequence);
      persistence.put(order.getId(), order);
    }
  }
}
