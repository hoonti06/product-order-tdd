package me.hoonti06.productordertdd.product.create.v4;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v4/create/products")
public class CreateProductServiceV4 {

  private final CreateProductPortV4 productPort;

  public CreateProductServiceV4(CreateProductPortV4 productPort) {
    this.productPort = productPort;
  }

  @PostMapping
  @Transactional
  public ResponseEntity<Void> addProduct(@RequestBody AddProductRequestV4 request) {
    final CreateProductV4 product = new CreateProductV4(request.name(), request.price(), request.discountPolicy());
    productPort.save(product);

    return ResponseEntity.status(HttpStatus.CREATED).build();
  }

}
