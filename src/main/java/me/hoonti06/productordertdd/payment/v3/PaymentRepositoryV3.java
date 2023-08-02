package me.hoonti06.productordertdd.payment.v3;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Repository;

@Repository
public class PaymentRepositoryV3 {

  private Map<Long, PaymentV3> persistence = new HashMap<>();
  private long sequence = 0L;

  public void save(PaymentV3 payment) {
    payment.assignId(++sequence);
    persistence.put(payment.getId(), payment);
  }
}
