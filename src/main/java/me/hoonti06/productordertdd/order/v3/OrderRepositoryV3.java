package me.hoonti06.productordertdd.order.v3;

import java.util.HashMap;
import java.util.Map;
import me.hoonti06.productordertdd.order.v2.OrderV2;
import org.springframework.stereotype.Repository;

@Repository
public class OrderRepositoryV3 {
  private final Map<Long, OrderV3> persistence = new HashMap<>();
  private Long sequence = 0L;


  public void save(OrderV3 order) {
    order.assignId(++sequence);
    persistence.put(order.getId(), order);
  }
}
