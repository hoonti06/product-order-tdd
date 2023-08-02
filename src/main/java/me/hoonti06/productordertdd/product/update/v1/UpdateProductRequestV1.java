package me.hoonti06.productordertdd.product.update.v1;

import org.springframework.util.Assert;

public record UpdateProductRequestV1(

  String name,
  int price,
  UpdateDiscountPolicyV1 discountPolicy
) {
  public UpdateProductRequestV1 {
    Assert.hasText(name, "상품명은 필수입니다.");
    Assert.isTrue(price > 0, "상품 가격은 0보다 커야 합니다.");
    Assert.notNull(discountPolicy, "할인 정책은 필수입니다.");
  }
}
