package me.hoonti06.productordertdd.product.create.v2;

import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.springframework.http.MediaType;

public class CreateProductStepsV2 {

  public static ExtractableResponse<Response> 상품등록요청(AddProductRequestV2 request) {
    return RestAssured.given().log().all()
        .contentType(MediaType.APPLICATION_JSON_VALUE)
        .body(request)
        .when()
        .post("/products")
        .then()
        .log().all().extract();
  }

  public static AddProductRequestV2 상품등록요청_생성() {
    final String name = "상품명";
    final int price = 10000;
    final CreateDiscountPolicyV2 discountPolicy = CreateDiscountPolicyV2.NONE;
    return new AddProductRequestV2(name, price, discountPolicy);
  }

}