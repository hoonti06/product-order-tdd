package me.hoonti06.productordertdd.product.update.v1;

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

@Entity(name = "UpdateProductV1")
@Getter
@Table(name = "products")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UpdateProductV1 {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  private int price;
  @Enumerated(EnumType.STRING)
  private UpdateDiscountPolicyV1 discountPolicy;

  public UpdateProductV1(final String name, final int price, final UpdateDiscountPolicyV1 discountPolicy) {
    this.name = name;
    this.price = price;
    this.discountPolicy = discountPolicy;
  }

  public void update(String name, int price, UpdateDiscountPolicyV1 discountPolicy) {
    Assert.hasText(name, "상품명은 필수입니다.");
    Assert.isTrue(price > 0, "상품 가격은 0보다 커야 합니다.");
    Assert.notNull(discountPolicy, "할인 정책은 필수입니다.");
    this.name = name;
    this.price = price;
    this.discountPolicy = discountPolicy;
  }
}
