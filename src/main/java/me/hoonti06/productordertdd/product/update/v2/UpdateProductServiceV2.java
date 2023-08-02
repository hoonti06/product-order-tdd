package me.hoonti06.productordertdd.product.update.v2;

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
@RequestMapping("/v2/update/products")
public class UpdateProductServiceV2 {

  private final UpdateProductPortV2 productPort;

  public UpdateProductServiceV2(final UpdateProductPortV2 productPort) {
    this.productPort = productPort;
  }

  @PostMapping
  @Transactional
  public ResponseEntity<Void> addProduct(@RequestBody final AddProductRequestV2 request) {
    final UpdateProductV2 product = new UpdateProductV2(request.name(), request.price(), request.discountPolicy());
    productPort.save(product);

    return ResponseEntity.status(HttpStatus.CREATED).build();
  }

  @GetMapping("/{productId}")
  public ResponseEntity<GetProductResponseV2> getProduct(@PathVariable final long productId) {
    final UpdateProductV2 product = productPort.getProduct(productId);
    return ResponseEntity.ok(new GetProductResponseV2(product.getId(), product.getName(), product.getPrice(), product.getDiscountPolicy()));
  }

  public void updateProduct(Long productId, UpdateProductRequestV2 request) {
    UpdateProductV2 product = productPort.getProduct(productId);
    product.update(request.name(), request.price(), request.discountPolicy());
    productPort.save(product);
  }
}
