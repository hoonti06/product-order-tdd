package me.hoonti06.productordertdd.product.update.v4;

import javax.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v4/update/products")
public class UpdateProductServiceV4 {

  private final UpdateProductPortV4 productPort;

  public UpdateProductServiceV4(UpdateProductPortV4 productPort) {
    this.productPort = productPort;
  }

  @PostMapping
  @Transactional
  public ResponseEntity<Void> addProduct(@RequestBody AddProductRequestV4 request) {
    final UpdateProductV4 product = new UpdateProductV4(request.name(), request.price(), request.discountPolicy());
    productPort.save(product);

    return ResponseEntity.status(HttpStatus.CREATED).build();
  }

  @GetMapping("/{productId}")
  public ResponseEntity<GetProductResponseV4> getProduct(@PathVariable Long productId) {
    final UpdateProductV4 product = productPort.getProduct(productId);
    final GetProductResponseV4 response = new GetProductResponseV4(product.getId(),
        product.getName(),
        product.getPrice(),
        product.getDiscountPolicy());
    return ResponseEntity.ok(response);
  }

  @PatchMapping("/{productId}")
  public ResponseEntity<Void> updateProduct(
      @PathVariable Long productId,
      @RequestBody UpdateProductRequestV4 request) {
    UpdateProductV4 product = productPort.getProduct(productId);
    product.update(request.name(), request.price(), request.discountPolicy());

    productPort.save(product);
    return ResponseEntity.ok().build();
  }
}
