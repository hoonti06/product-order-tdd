package me.hoonti06.productordertdd.product.create.v3;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Repository;

@Repository
public class CreateProductRepositoryV3 {
  private final Map<Long, CreateProductV3> persistence = new HashMap<>();
  private Long sequence = 0L;


  public void save(CreateProductV3 product) {
    product.assignId(++sequence);
    persistence.put(product.getId(), product);
  }

}
