package me.hoonti06.productordertdd.order.v4;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import me.hoonti06.productordertdd.ApiTest;
import me.hoonti06.productordertdd.product.ProductSteps;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

public class OrderApiTestV4 extends ApiTest {
  @Test
  void 상품주문() {
    // given
    ProductSteps.상품등록요청(ProductSteps.상품등록요청_생성());

    // when
    final var response = OrderStepsV4.상품주문요청(OrderStepsV4.상품주문요청_생성());

    // then
    assertThat(response.statusCode()).isEqualTo(HttpStatus.CREATED.value());
  }

}
