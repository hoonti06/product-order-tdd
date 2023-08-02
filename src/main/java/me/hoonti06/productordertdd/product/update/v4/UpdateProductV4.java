package me.hoonti06.productordertdd.product.update.v4;


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
class UpdateProductV4 {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  private int price;
  @Enumerated(EnumType.STRING)
  private UpdateDiscountPolicyV4 discountPolicy;

  public UpdateProductV4(final String name, final int price, final UpdateDiscountPolicyV4 discountPolicy) {
    this.name = name;
    this.price = price;
    this.discountPolicy = discountPolicy;
  }

  public void update(String name, int price, UpdateDiscountPolicyV4 discountPolicy) {
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
