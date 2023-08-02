package me.hoonti06.productordertdd.product.update.v1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class UpdateProductV1Test {

  @Test
  void update() {
    // given
    UpdateProductV1 product = new UpdateProductV1("상품명", 1000, UpdateDiscountPolicyV1.NONE);

    // when
    product.update("상품 수정", 2000, UpdateDiscountPolicyV1.NONE);

    // then
    Assertions.assertThat(product.getName()).isEqualTo("상품 수정");
    Assertions.assertThat(product.getPrice()).isEqualTo(2000);
  }
  
}