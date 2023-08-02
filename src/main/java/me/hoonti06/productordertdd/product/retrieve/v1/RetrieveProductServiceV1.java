package me.hoonti06.productordertdd.product.retrieve.v1;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/retreive/products")
public class RetrieveProductServiceV1 {

  private final RetrieveProductPortV1 productPort;

  public RetrieveProductServiceV1(final RetrieveProductPortV1 productPort) {
    this.productPort = productPort;
  }

  @PostMapping
  @Transactional
  public ResponseEntity<Void> addProduct(@RequestBody final AddProductRequestV1 request) {
    final RetrieveProductV1 product = new RetrieveProductV1(request.name(), request.price(), request.discountPolicy());
    productPort.save(product);

    return ResponseEntity.status(HttpStatus.CREATED).build();
  }

  public GetProductResponseV1 getProduct(final long productId) {
    final RetrieveProductV1 product = productPort.getProduct(productId);
    return new GetProductResponseV1(product.getId(), product.getName(), product.getPrice(), product.getDiscountPolicy());
  }
}
