package me.hoonti06.productordertdd.product.update.v2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class UpdateProductV2Test {

  @Test
  void update() {
    // given
    UpdateProductV2 product = new UpdateProductV2("상품명", 1000, UpdateDiscountPolicyV2.NONE);

    // when
    product.update("상품 수정", 2000, UpdateDiscountPolicyV2.NONE);

    // then
    Assertions.assertThat(product.getName()).isEqualTo("상품 수정");
    Assertions.assertThat(product.getPrice()).isEqualTo(2000);
  }
  
}