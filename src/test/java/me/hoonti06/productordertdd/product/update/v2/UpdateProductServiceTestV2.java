package me.hoonti06.productordertdd.product.update.v2;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

@SpringBootTest
public class UpdateProductServiceTestV2 {

  @Autowired
  private UpdateProductServiceV2 productService;

  @Test
  void 상품수정() {
    // given
    productService.addProduct(UpdateProductStepsV2.상품등록요청_생성());
    final Long productId = 1L;
    final UpdateProductRequestV2 request = new UpdateProductRequestV2("상품 수정", 2000, UpdateDiscountPolicyV2.NONE);

    // when
    productService.updateProduct(productId, request);


    // then
    final ResponseEntity<GetProductResponseV2> response = productService.getProduct(productId);
    final GetProductResponseV2 productResponse = response.getBody();
    assertThat(productResponse.name()).isEqualTo("상품 수정");
    assertThat(productResponse.price()).isEqualTo(2000);

  }

}
