package me.hoonti06.productordertdd.payment.v4;

import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import me.hoonti06.productordertdd.payment.PaymentRequest;
import org.springframework.http.MediaType;

public class PaymentStepsV4 {

  public static PaymentRequest 주문결제요청_생성() {
    final Long orderId = 1L;
    final String cardNumber = "1234-1234-1234-1234";
    return new PaymentRequest(orderId, cardNumber);
  }

  static ExtractableResponse<Response> 주문결제요청(PaymentRequest request) {
    return RestAssured.given().log().all()
        .contentType(MediaType.APPLICATION_JSON_VALUE)
        .body(request)
        .post("/v4/payments")
        .then()
        .log().all().extract();
  }
}
