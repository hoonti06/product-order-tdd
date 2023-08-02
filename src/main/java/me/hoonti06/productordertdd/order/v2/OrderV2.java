package me.hoonti06.productordertdd.order.v2;

import me.hoonti06.productordertdd.product.z.domain.Product;
import org.springframework.util.Assert;

public class OrderV2 {
  private Long id;

  private final Product product;
  private final int quantity;

  public OrderV2(final Product product, final int quantity) {
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
