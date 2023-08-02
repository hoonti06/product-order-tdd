package me.hoonti06.productordertdd.product.update.v4;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UpdateProductRepositoryV4 extends JpaRepository<UpdateProductV4, Long> {
//  class ProductRepository {
//  void save(Product product) {
//    System.out.println("hi");
//  }
}
