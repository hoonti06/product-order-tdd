package me.hoonti06.productordertdd.product.create.v3;

public class CreateProductV3 {
  private Long id;
  private final String name;
  private final int price;
  private final CreateDiscountPolicyV3 discountPolicy;

  public CreateProductV3(String name, int price, CreateDiscountPolicyV3 discountPolicy) {
    this.name = name;
    this.price = price;
    this.discountPolicy = discountPolicy;
  }

  public void assignId(Long id) {
    this.id = id;
  }

  Long getId() {
    return id;
  }

}
