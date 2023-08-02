package me.hoonti06.productordertdd.order.v2;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Repository;

@Repository
public class OrderRepositoryV2 {
  private final Map<Long, OrderV2> persistence = new HashMap<>();
  private Long sequence = 0L;


  public void save(OrderV2 order) {
    order.assignId(++sequence);
    persistence.put(order.getId(), order);
  }
}
