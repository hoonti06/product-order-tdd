package me.hoonti06.productordertdd.product.update.v2;

import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.springframework.http.MediaType;

public class UpdateProductStepsV2 {

  public static ExtractableResponse<Response> 상품등록요청(AddProductRequestV2 request) {
    return RestAssured.given().log().all()
        .contentType(MediaType.APPLICATION_JSON_VALUE)
        .body(request)
        .when()
        .post("/v2/update/products")
        .then()
        .log().all().extract();
  }

  public static AddProductRequestV2 상품등록요청_생성() {
    final String name = "상품명";
    final int price = 10000;
    final UpdateDiscountPolicyV2 discountPolicy = UpdateDiscountPolicyV2.NONE;
    return new AddProductRequestV2(name, price, discountPolicy);
  }

  public static ExtractableResponse<Response> 상품조회요청(Long productId) {
    return RestAssured.given().log().all()
        .when()
        .get("/v2/update/products/{productId}", productId)
        .then()
        .log().all().extract();
  }

  public static UpdateProductRequestV2 상품수정요청_생성() {
    return new UpdateProductRequestV2("상품 수정", 2000, UpdateDiscountPolicyV2.NONE);
  }

  public static ExtractableResponse<Response> 상품수정요청(Long productId) {
    return RestAssured.given().log().all()
        .contentType(MediaType.APPLICATION_JSON_VALUE)
        .body(상품수정요청_생성())
        .when()
        .patch("/v2/update/products/{productId}", productId)
        .then()
        .log().all().extract();
  }

}