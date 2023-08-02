package me.hoonti06.productordertdd.product.create.v2;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Component
public class CreateProductServiceV2 {

  private final CreateProductPortV2 productPort;

  public CreateProductServiceV2(CreateProductPortV2 productPort) {
    this.productPort = productPort;
  }

  @PostMapping
  public void addProduct(@RequestBody AddProductRequestV2 request) {
    final CreateProductV2 product = new CreateProductV2(request.name(), request.price(), request.discountPolicy());
    productPort.save(product);
  }

}
