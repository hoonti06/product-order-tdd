package me.hoonti06.productordertdd.product.z.domain;


import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.util.Assert;

@Entity
@Getter
@Table(name = "products")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public
class Product {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  private int price;
  @Enumerated(EnumType.STRING)
  private DiscountPolicy discountPolicy;

  public Product(final String name, final int price, final DiscountPolicy discountPolicy) {
    this.name = name;
    this.price = price;
    this.discountPolicy = discountPolicy;
  }

  public void update(String name, int price, DiscountPolicy discountPolicy) {
    Assert.hasText(name, "");
    Assert.isTrue(price > 0, "");
    Assert.notNull(discountPolicy, "");

    this.name = name;
    this.price = price;
    this.discountPolicy = discountPolicy;
  }

  public int getDiscountedPrice() {
    return discountPolicy.applyDiscount(price);
  }
}
