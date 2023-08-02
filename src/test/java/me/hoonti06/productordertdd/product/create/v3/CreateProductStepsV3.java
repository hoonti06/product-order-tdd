package me.hoonti06.productordertdd.product.create.v3;

import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.springframework.http.MediaType;

public class CreateProductStepsV3 {

  public static ExtractableResponse<Response> 상품등록요청(AddProductRequestV3 request) {
    return RestAssured.given().log().all()
        .contentType(MediaType.APPLICATION_JSON_VALUE)
        .body(request)
        .when()
        .post("/v3/create/products")
        .then()
        .log().all().extract();
  }

  public static AddProductRequestV3 상품등록요청_생성() {
    final String name = "상품명";
    final int price = 10000;
    final CreateDiscountPolicyV3 discountPolicy = CreateDiscountPolicyV3.NONE;
    return new AddProductRequestV3(name, price, discountPolicy);
  }

}