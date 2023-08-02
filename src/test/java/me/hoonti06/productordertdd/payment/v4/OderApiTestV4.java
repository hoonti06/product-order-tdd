package me.hoonti06.productordertdd.payment.v4;

import static org.assertj.core.api.Assertions.assertThat;

import me.hoonti06.productordertdd.ApiTest;
import me.hoonti06.productordertdd.order.v4.OrderStepsV4;
import me.hoonti06.productordertdd.payment.PaymentRequest;
import me.hoonti06.productordertdd.product.ProductSteps;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

public class OderApiTestV4 extends ApiTest {
  @Test
  void 주문결제() {
    // given
    ProductSteps.상품등록요청(ProductSteps.상품등록요청_생성());
    OrderStepsV4.상품주문요청(OrderStepsV4.상품주문요청_생성());
    final PaymentRequest request = PaymentStepsV4.주문결제요청_생성();

    // when
    final var response = PaymentStepsV4.주문결제요청(request);

    // then
    assertThat(response.statusCode()).isEqualTo(HttpStatus.OK.value());
  }

}
