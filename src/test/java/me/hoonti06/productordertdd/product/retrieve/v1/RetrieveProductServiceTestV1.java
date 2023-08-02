package me.hoonti06.productordertdd.product.retrieve.v1;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RetrieveProductServiceTestV1 {

  @Autowired
  private RetrieveProductServiceV1 productService;

  @Test
  void 상품조회() {
    // 상품등록
    productService.addProduct(RetrieveProductStepsV1.상품등록요청_생성());
    final long productId = 1L;

    // 상품 조회
    final GetProductResponseV1 response = productService.getProduct(productId);

    // 상품 응답 검증
    assertThat(response).isNotNull();
  }

}
