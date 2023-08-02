package me.hoonti06.productordertdd.product.retrieve.v4;

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
@RequestMapping("/v4/retrieve/products")
public class RetrieveProductServiceV4 {

  private final RetrieveProductPortV4 productPort;

  public RetrieveProductServiceV4(final RetrieveProductPortV4 productPort) {
    this.productPort = productPort;
  }

  @PostMapping
  @Transactional
  public ResponseEntity<Void> addProduct(@RequestBody final AddProductRequestV4 request) {
    final RetrieveProductV4 product = new RetrieveProductV4(request.name(), request.price(), request.discountPolicy());
    productPort.save(product);

    return ResponseEntity.status(HttpStatus.CREATED).build();
  }

  @GetMapping("/{productId}")
  public GetProductResponseV4 getProduct(@PathVariable final long productId) {
    final RetrieveProductV4 product = productPort.getProduct(productId);
    return new GetProductResponseV4(product.getId(), product.getName(), product.getPrice(), product.getDiscountPolicy());
  }
}
