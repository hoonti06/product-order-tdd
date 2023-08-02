package me.hoonti06.productordertdd.order.v4;

import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import me.hoonti06.productordertdd.order.CreateOrderRequest;
import org.springframework.http.MediaType;

public class OrderStepsV4 {
  public static CreateOrderRequest 상품주문요청_생성() {
    final Long productId = 1L;
    final int quantity = 2;
    return new CreateOrderRequest(productId, quantity);
  }

  public static ExtractableResponse<Response> 상품주문요청(final CreateOrderRequest request) {
    return RestAssured.given().log().all()
        .contentType(MediaType.APPLICATION_JSON_VALUE)
        .body(request)
        .when()
        .post("/v4/orders")
        .then()
        .log().all().extract();
  }
}
