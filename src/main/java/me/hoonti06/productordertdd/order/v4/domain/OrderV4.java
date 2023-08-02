package me.hoonti06.productordertdd.order.v4.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.hoonti06.productordertdd.product.z.domain.Product;
import org.springframework.util.Assert;

@Entity
@Table(name="orders")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OrderV4 {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

//  @OneToOne(fetch = FetchType.LAZY)
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "product_id")
//  @OneToOne
  private Product product;
  private int quantity;

  public OrderV4(final Product product, final int quantity) {
    Assert.notNull(product, "상품은 필수입니다.");
    Assert.isTrue(quantity > 0, "수량은 0보다 커야 합니다.");
    this.product = product;
    this.quantity = quantity;
  }

  public int getTotalPrice() {
    return product.getDiscountedPrice() * quantity;
  }
}
