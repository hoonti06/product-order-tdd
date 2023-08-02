package me.hoonti06.productordertdd.product.retrieve.v1;

import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.springframework.http.MediaType;

public class RetrieveProductStepsV1 {

  public static ExtractableResponse<Response> 상품등록요청(AddProductRequestV1 request) {
    return RestAssured.given().log().all()
        .contentType(MediaType.APPLICATION_JSON_VALUE)
        .body(request)
        .when()
        .post("/v1/retrieve/products")
        .then()
        .log().all().extract();
  }

  public static AddProductRequestV1 상품등록요청_생성() {
    final String name = "상품명";
    final int price = 10000;
    final RetrieveDiscountPolicyV1 discountPolicy = RetrieveDiscountPolicyV1.NONE;
    return new AddProductRequestV1(name, price, discountPolicy);
  }

}