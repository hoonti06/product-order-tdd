package me.hoonti06.productordertdd.product;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import me.hoonti06.productordertdd.product.z.domain.DiscountPolicy;
import me.hoonti06.productordertdd.product.z.domain.Product;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class ProductTest {

  @Test
  void update() {
    // given
    Product product = new Product("상품명", 1000, DiscountPolicy.NONE);

    // when
    product.update("상품 수정", 2000, DiscountPolicy.NONE);

    // then
    Assertions.assertThat(product.getName()).isEqualTo("상품 수정");
    Assertions.assertThat(product.getPrice()).isEqualTo(2000);
  }
  
  @Test
  void none_discounted_product() {
    // given
    Product product = new Product("상품명", 1000, DiscountPolicy.NONE);

    // when
    final int discountedPrice = product.getDiscountedPrice();

    // then
    assertThat(discountedPrice).isEqualTo(1000);
  }

  @Test
  void fix_1000_discounted_product() {
    // given
    Product product = new Product("상품명", 1000, DiscountPolicy.FIXED_1000_AMOUNT);

    // when
    final int discountedPrice = product.getDiscountedPrice();

    // then
    assertThat(discountedPrice).isEqualTo(0);
  }

}