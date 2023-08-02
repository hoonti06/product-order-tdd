package me.hoonti06.productordertdd.product.create.v2;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Repository;

@Repository
public class CreateProductRepositoryV2 {
  private final Map<Long, CreateProductV2> persistence = new HashMap<>();
  private Long sequence = 0L;


  public void save(CreateProductV2 product) {
    product.assignId(++sequence);
    persistence.put(product.getId(), product);
  }

}
