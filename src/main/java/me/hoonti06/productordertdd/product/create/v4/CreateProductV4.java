package me.hoonti06.productordertdd.product.create.v4;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "products")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CreateProductV4 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int price;
    @Enumerated(EnumType.STRING)
    private CreateDiscountPolicyV4 discountPolicy;

    public CreateProductV4(final String name, final int price, final CreateDiscountPolicyV4 discountPolicy) {
      this.name = name;
      this.price = price;
      this.discountPolicy = discountPolicy;
    }

}
