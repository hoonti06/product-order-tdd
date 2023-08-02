package me.hoonti06.productordertdd.product.update.v4;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;

class UpdateDiscountPolicyV4Test {
  @Test
  void noneDiscountPolicy() {
    // given
    int price = 1000;
    final int discountedPrice = UpdateDiscountPolicyV4.NONE.applyDiscount(price);
    assertThat(discountedPrice).isEqualTo(1000);
  }

  @Test
  void fixed1000AmountDiscountPolicyPriceGte1000() {
    int price = 2000;
    final int discountedPrice = UpdateDiscountPolicyV4.FIXED_1000_AMOUNT.applyDiscount(price);
    assertThat(discountedPrice).isEqualTo(1000);
  }

  @Test
  void fixed1000AmountDiscountPolicyPriceLt1000() {
    int price = 500;
    final int discountedPrice = UpdateDiscountPolicyV4.FIXED_1000_AMOUNT.applyDiscount(price);
    assertThat(discountedPrice).isEqualTo(0);
  }

}