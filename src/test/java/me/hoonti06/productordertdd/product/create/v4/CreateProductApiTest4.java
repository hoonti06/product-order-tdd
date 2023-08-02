package me.hoonti06.productordertdd.product.create.v4;

import static org.assertj.core.api.Assertions.assertThat;

import me.hoonti06.productordertdd.ApiTest;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

public class CreateProductApiTest4 extends ApiTest {
  @Test
  void 상품_등록() {
    final var request = CreateProductStepsV4.상품등록요청_생성();

    final var response = CreateProductStepsV4.상품등록요청(request);

    assertThat(response.statusCode()).isEqualTo(HttpStatus.CREATED.value());
  }

}
