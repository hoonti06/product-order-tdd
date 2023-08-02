package me.hoonti06.productordertdd.product.create.v3;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v3/create/products")
public class CreateProductServiceV3 {

  private final CreateProductPortV3 productPort;

  public CreateProductServiceV3(CreateProductPortV3 productPort) {
    this.productPort = productPort;
  }

  @PostMapping
  public ResponseEntity<Void> addProduct(@RequestBody AddProductRequestV3 request) {
    final CreateProductV3 product = new CreateProductV3(request.name(), request.price(), request.discountPolicy());
    productPort.save(product);

    return ResponseEntity.status(HttpStatus.CREATED).build();
  }

}
