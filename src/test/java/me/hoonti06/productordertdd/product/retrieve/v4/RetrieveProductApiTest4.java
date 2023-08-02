package me.hoonti06.productordertdd.product.retrieve.v4;

import static org.assertj.core.api.Assertions.assertThat;

import me.hoonti06.productordertdd.ApiTest;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

public class RetrieveProductApiTest4 extends ApiTest {
  @Test
  void 상품_등록() {
    final var request = RetrieveProductStepsV4.상품등록요청_생성();

    final var response = RetrieveProductStepsV4.상품등록요청(request);

    assertThat(response.statusCode()).isEqualTo(HttpStatus.CREATED.value());
  }

  @Test
  void 상품_조회() {
    RetrieveProductStepsV4.상품등록요청(RetrieveProductStepsV4.상품등록요청_생성());
    Long productId = 1L;

    final var response = RetrieveProductStepsV4.상품조회요청(productId);

    assertThat(response.statusCode()).isEqualTo(HttpStatus.OK.value());
  }

}
