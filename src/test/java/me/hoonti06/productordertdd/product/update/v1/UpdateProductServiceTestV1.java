package me.hoonti06.productordertdd.product.update.v1;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.BDDMockito.given;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class UpdateProductServiceTestV1 {

  private UpdateProductServiceV1 productService;
  private UpdateProductPortV1 productPort;

  @BeforeEach
  void setUp() {
    productPort = Mockito.mock(UpdateProductPortV1.class);
    productService = new UpdateProductServiceV1(productPort);
  }

  @Test
  void 상품수정() {
    // given
    final Long productId = 1L;
    final UpdateProductRequestV1 request = new UpdateProductRequestV1("상품 수정", 2000, UpdateDiscountPolicyV1.NONE);
    final UpdateProductV1 product = new UpdateProductV1("상품명", 1000, UpdateDiscountPolicyV1.NONE);


    given(productPort.getProduct(productId)).willReturn(product);

    // when
    productService.updateProduct(productId, request);

    // then
    assertThat(product.getName()).isEqualTo("상품 수정");
    assertThat(product.getPrice()).isEqualTo(2000);

  }

}
