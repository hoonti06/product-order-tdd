package me.hoonti06.productordertdd.product.z.applicaiton.service;

import javax.transaction.Transactional;
import me.hoonti06.productordertdd.product.z.applicaiton.port.ProductPort;
import me.hoonti06.productordertdd.product.z.domain.Product;
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
@RequestMapping("/products")
public class ProductService {

  private final ProductPort productPort;

  public ProductService(ProductPort productPort) {
    this.productPort = productPort;
  }

  @PostMapping
  @Transactional
  public ResponseEntity<Void> addProduct(@RequestBody AddProductRequest request) {
    final Product product = new Product(request.name(), request.price(), request.discountPolicy());
    productPort.save(product);

    return ResponseEntity.status(HttpStatus.CREATED).build();
  }

  @GetMapping("/{productId}")
  public ResponseEntity<GetProductResponse> getProduct(@PathVariable Long productId) {
    final Product product = productPort.getProduct(productId);
    final GetProductResponse response = new GetProductResponse(product.getId(),
        product.getName(),
        product.getPrice(),
        product.getDiscountPolicy());
    return ResponseEntity.ok(response);
  }

  @PatchMapping("/{productId}")
  public ResponseEntity<Void> updateProduct(
      @PathVariable Long productId,
      @RequestBody UpdateProductRequest request) {
    Product product = productPort.getProduct(productId);
    product.update(request.name(), request.price(), request.discountPolicy());

    productPort.save(product);
    return ResponseEntity.ok().build();
  }
}
