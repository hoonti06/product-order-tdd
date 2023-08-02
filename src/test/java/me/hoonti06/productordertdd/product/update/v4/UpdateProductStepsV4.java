package me.hoonti06.productordertdd.product.update.v4;

import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.springframework.http.MediaType;

public class UpdateProductStepsV4 {

  public static ExtractableResponse<Response> 상품등록요청(AddProductRequestV4 request) {
    return RestAssured.given().log().all()
        .contentType(MediaType.APPLICATION_JSON_VALUE)
        .body(request)
        .when()
        .post("/v4/update/products")
        .then()
        .log().all().extract();
  }

  public static AddProductRequestV4 상품등록요청_생성() {
    final String name = "상품명";
    final int price = 10000;
    final UpdateDiscountPolicyV4 discountPolicy = UpdateDiscountPolicyV4.NONE;
    return new AddProductRequestV4(name, price, discountPolicy);
  }

  public static ExtractableResponse<Response> 상품조회요청(Long productId) {
    return RestAssured.given().log().all()
        .when()
        .get("/v4/update/products/{productId}", productId)
        .then()
        .log().all().extract();
  }

  public static UpdateProductRequestV4 상품수정요청_생성() {
    return new UpdateProductRequestV4("상품 수정", 2000, UpdateDiscountPolicyV4.NONE);
  }

  public static ExtractableResponse<Response> 상품수정요청(Long productId) {
    return RestAssured.given().log().all()
        .contentType(MediaType.APPLICATION_JSON_VALUE)
        .body(상품수정요청_생성())
        .when()
        .patch("/v4/update/products/{productId}", productId)
        .then()
        .log().all().extract();
  }

}