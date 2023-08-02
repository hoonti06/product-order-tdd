package me.hoonti06.productordertdd.payment.v2;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Repository;

@Repository
public class PaymentRepositoryV2 {

  private Map<Long, PaymentV2> persistence = new HashMap<>();
  private long sequence = 0L;

  public void save(PaymentV2 payment) {
    payment.assignId(++sequence);
    persistence.put(payment.getId(), payment);
  }
}
