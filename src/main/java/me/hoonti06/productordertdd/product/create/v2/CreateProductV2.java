package me.hoonti06.productordertdd.product.create.v2;

public class CreateProductV2 {
  private Long id;
  private final String name;
  private final int price;
  private final CreateDiscountPolicyV2 discountPolicy;

  public CreateProductV2(String name, int price, CreateDiscountPolicyV2 discountPolicy) {
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
