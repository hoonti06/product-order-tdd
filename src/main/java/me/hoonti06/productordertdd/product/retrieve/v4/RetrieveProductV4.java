package me.hoonti06.productordertdd.product.retrieve.v4;

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

@Entity(name = "RetrieveProductV4")
@Getter
@Table(name = "products")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RetrieveProductV4 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int price;
    @Enumerated(EnumType.STRING)
    private RetrieveDiscountPolicyV4 discountPolicy;

    public RetrieveProductV4(final String name, final int price, final RetrieveDiscountPolicyV4 discountPolicy) {
      this.name = name;
      this.price = price;
      this.discountPolicy = discountPolicy;
    }

}
