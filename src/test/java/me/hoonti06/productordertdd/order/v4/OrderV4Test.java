package me.hoonti06.productordertdd.order.v4;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import me.hoonti06.productordertdd.order.v4.domain.OrderV4;
import me.hoonti06.productordertdd.product.z.domain.DiscountPolicy;
import me.hoonti06.productordertdd.product.z.domain.Product;
import org.junit.jupiter.api.Test;

public class OrderV4Test {
  @Test
  void getTotalPrice() {
    // given
    final OrderV4 order = new OrderV4(new Product("상품명", 1000, DiscountPolicy.NONE), 2);

    // when
    final int totalPrice = order.getTotalPrice();

    // then
    assertThat(totalPrice).isEqualTo(2000);
  }

}
