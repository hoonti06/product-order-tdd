package me.hoonti06.productordertdd.product.retrieve.v1;

import org.springframework.util.Assert;

public record AddProductRequestV1(String name, int price, RetrieveDiscountPolicyV1 discountPolicy) {

  public AddProductRequestV1 {
    Assert.hasText(name, "상품명은 필수입니다.");
    Assert.isTrue(price > 0, "상품 가격은 0보다 커야 합니다.");
    Assert.notNull(discountPolicy, "할인 정책은 필수입니다.");

  }


}
