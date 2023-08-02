package me.hoonti06.productordertdd.order.v4.adapter;

import me.hoonti06.productordertdd.order.v4.domain.OrderV4;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepositoryV4 extends JpaRepository<OrderV4, Long> {
}
