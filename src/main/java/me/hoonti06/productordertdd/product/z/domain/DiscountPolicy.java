package me.hoonti06.productordertdd.product.z.domain;

public enum DiscountPolicy {
  NONE {
    @Override
    public int applyDiscount(int price) {
      return price;
    }
  },
  FIXED_1000_AMOUNT {
    @Override
    public int applyDiscount(int price) {
      return Math.max(price - 1000, 0);
    }
  };

  public abstract int applyDiscount(int price);
}
