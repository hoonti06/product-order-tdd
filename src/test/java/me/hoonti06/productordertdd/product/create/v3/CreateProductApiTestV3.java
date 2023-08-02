package me.hoonti06.productordertdd.product.create.v3;

import static org.assertj.core.api.Assertions.assertThat;

import me.hoonti06.productordertdd.ApiTest;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

public class CreateProductApiTestV3 extends ApiTest {
  @Test
  void 상품_등록() {
    final var request = CreateProductStepsV3.상품등록요청_생성();

    final var response = CreateProductStepsV3.상품등록요청(request);

    assertThat(response.statusCode()).isEqualTo(HttpStatus.CREATED.value());
  }

}
