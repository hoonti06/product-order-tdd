package me.hoonti06.productordertdd.product.update.v4;

import static org.assertj.core.api.Assertions.assertThat;

import me.hoonti06.productordertdd.ApiTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

public class UpdateProductApiTestV4 extends ApiTest {

  @Autowired
  private UpdateProductRepositoryV4 productRepository;

  @Test
  void 상품_등록() {
    // given
    final var request = UpdateProductStepsV4.상품등록요청_생성();

    final var response = UpdateProductStepsV4.상품등록요청(request);

    assertThat(response.statusCode()).isEqualTo(HttpStatus.CREATED.value());
  }

  @Test
  void 상품_조회() {
    UpdateProductStepsV4.상품등록요청(UpdateProductStepsV4.상품등록요청_생성());
    Long productId = 1L;

    final var response = UpdateProductStepsV4.상품조회요청(productId);

    assertThat(response.statusCode()).isEqualTo(HttpStatus.OK.value());
  }

  @Test
  void 상품_수정() {
    UpdateProductStepsV4.상품등록요청(UpdateProductStepsV4.상품등록요청_생성());

    final Long productId = 1L;
    final var response = UpdateProductStepsV4.상품수정요청(productId);

    assertThat(response.statusCode()).isEqualTo(HttpStatus.OK.value());
    assertThat(productRepository.findById(productId).get().getName()).isEqualTo("상품 수정");
  }

}
