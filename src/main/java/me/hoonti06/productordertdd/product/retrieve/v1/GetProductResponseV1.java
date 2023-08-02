package me.hoonti06.productordertdd.product.retrieve.v1;

import org.springframework.util.Assert;

public record GetProductResponseV1(
    Long id,
    String name,
    int price,
    RetrieveDiscountPolicyV1 discountPolicy
) {

  public GetProductResponseV1 {
    Assert.notNull(id, "상품 ID는 필수입니다.");
    Assert.hasText(name, "상품명은 필수입니다.");
    Assert.notNull(discountPolicy, "할인 정책은 필수입니다.");

  }

}
