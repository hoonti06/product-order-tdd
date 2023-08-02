package me.hoonti06.productordertdd.product.update.v4;

import org.springframework.util.Assert;

public record AddProductRequestV4(String name, int price, UpdateDiscountPolicyV4 discountPolicy) {

  public AddProductRequestV4 {
    Assert.hasText(name, "상품명은 필수입니다.");
    Assert.isTrue(price > 0, "상품 가격은 0보다 커야 합니다.");
    Assert.notNull(discountPolicy, "할인 정책은 필수입니다.");

  }


}
