package me.hoonti06.productordertdd.order.v3;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import io.restassured.RestAssured;
import me.hoonti06.productordertdd.ApiTest;
import me.hoonti06.productordertdd.product.ProductSteps;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

public class OrderApiTestV3 extends ApiTest {
  @Test
  void 상품주문() {
    // given
    ProductSteps.상품등록요청(ProductSteps.상품등록요청_생성());

    // when
    final var response = RestAssured.given().log().all()
        .contentType(MediaType.APPLICATION_JSON_VALUE)
        .body(OrderStepsV3.상품주문요청_생성())
        .when()
        .post("/v3/orders")
        .then()
        .log().all().extract();

    // then
    assertThat(response.statusCode()).isEqualTo(HttpStatus.CREATED.value());
  }

}
