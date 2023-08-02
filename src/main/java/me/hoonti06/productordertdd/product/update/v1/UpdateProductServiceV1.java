package me.hoonti06.productordertdd.product.update.v1;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/update/products")
public class UpdateProductServiceV1 {

  private final UpdateProductPortV1 productPort;

  public UpdateProductServiceV1(final UpdateProductPortV1 productPort) {
    this.productPort = productPort;
  }

  @PostMapping
  @Transactional
  public ResponseEntity<Void> addProduct(@RequestBody final AddProductRequestV1 request) {
    final UpdateProductV1 product = new UpdateProductV1(request.name(), request.price(), request.discountPolicy());
    productPort.save(product);

    return ResponseEntity.status(HttpStatus.CREATED).build();
  }

  @GetMapping("/{productId}")
  public GetProductResponseV1 getProduct(@PathVariable final long productId) {
    final UpdateProductV1 product = productPort.getProduct(productId);
    return new GetProductResponseV1(product.getId(), product.getName(), product.getPrice(), product.getDiscountPolicy());
  }

  public void updateProduct(Long productId, UpdateProductRequestV1 request) {
    UpdateProductV1 product = productPort.getProduct(productId);
    product.update(request.name(), request.price(), request.discountPolicy());
  }
}
