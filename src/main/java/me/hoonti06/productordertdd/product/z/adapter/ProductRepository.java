package me.hoonti06.productordertdd.product.z.adapter;

import me.hoonti06.productordertdd.product.z.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
//  class ProductRepository {
//  void save(Product product) {
//    System.out.println("hi");
//  }
}
