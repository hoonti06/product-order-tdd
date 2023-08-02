package me.hoonti06.productordertdd.product.create.v2;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CreateProductServiceTestV2 {

  @Autowired
  private CreateProductServiceV2 productService;

  @Test
  void 상품등록() {
    final AddProductRequestV2 request = CreateProductStepsV2.상품등록요청_생성();

    productService.addProduct(request);
  }

}


