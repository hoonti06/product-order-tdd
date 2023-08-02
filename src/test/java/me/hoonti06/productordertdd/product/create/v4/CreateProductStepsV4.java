package me.hoonti06.productordertdd.product.create.v4;

import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.springframework.http.MediaType;

public class CreateProductStepsV4 {

  public static ExtractableResponse<Response> 상품등록요청(AddProductRequestV4 request) {
    return RestAssured.given().log().all()
        .contentType(MediaType.APPLICATION_JSON_VALUE)
        .body(request)
        .when()
        .post("/v4/create/products")
        .then()
        .log().all().extract();
  }

  public static AddProductRequestV4 상품등록요청_생성() {
    final String name = "상품명";
    final int price = 10000;
    final CreateDiscountPolicyV4 discountPolicy = CreateDiscountPolicyV4.NONE;
    return new AddProductRequestV4(name, price, discountPolicy);
  }

}