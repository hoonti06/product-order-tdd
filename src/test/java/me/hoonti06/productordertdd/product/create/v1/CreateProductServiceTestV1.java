package me.hoonti06.productordertdd.product.create.v1;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

public class CreateProductServiceTestV1 {

  private ProductService productService;

  @BeforeEach
  void setUp() {
    ProductRepository productRepository = new ProductRepository();
    ProductPort productPort = new ProductAdapter(productRepository);
    productService = new ProductService(productPort);
  }

  @Test
  void 상품등록() {
    final AddProductRequest request = 상품등록요청_생성();

    productService.addProduct(request);
  }

  private static AddProductRequest 상품등록요청_생성() {
    final String name = "상품명";
    final int price = 1000;
    final DiscountPolicy discountPolicy = DiscountPolicy.NONE;
    return new AddProductRequest(name, price, discountPolicy);
  }

  record AddProductRequest(String name, int price, DiscountPolicy discountPolicy) {

    AddProductRequest {
      Assert.hasText(name, "상품명은 필수입니다.");
      Assert.isTrue(price > 0, "상품 가격은 0보다 커야 합니다.");
      Assert.notNull(discountPolicy, "할인 정책은 필수입니다.");

    }

  }

  public class ProductService {

    private final ProductPort productPort;

    public ProductService(ProductPort productPort) {
      this.productPort = productPort;
    }

    public void addProduct(AddProductRequest request) {
      final Product product = new Product(request.name(), request.price(), request.discountPolicy());
      productPort.save(product);
    }
  }


  private enum DiscountPolicy {
    NONE
  }


  private class Product {
    private Long id;
    private final String name;
    private final int price;
    private final DiscountPolicy discountPolicy;

    private Product(String name, int price, DiscountPolicy discountPolicy) {
      this.name = name;
      this.price = price;
      this.discountPolicy = discountPolicy;
    }

    public void assignId(Long id) {
      this.id = id;
    }

    Long getId() {
      return id;
    }

  }

  private class ProductAdapter implements ProductPort {

    private final ProductRepository productRepository;

    ProductAdapter(ProductRepository productRepository) {
      this.productRepository = productRepository;
    }

    @Override
    public void save(Product product) {
      productRepository.save(product);

    }
  }

  private interface ProductPort {
    void save(Product product);
  }


  private class ProductRepository {
    private final Map<Long, Product> persistence = new HashMap<>();
    private Long sequence = 0L;


    public void save(Product product) {
      product.assignId(++sequence);
      persistence.put(product.getId(), product);
    }

  }
}


