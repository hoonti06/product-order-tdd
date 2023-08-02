package me.hoonti06.productordertdd.payment.v2;


import me.hoonti06.productordertdd.order.v4.application.service.OrderServiceV4;
import me.hoonti06.productordertdd.order.v4.OrderStepsV4;
import me.hoonti06.productordertdd.payment.PaymentRequest;
import me.hoonti06.productordertdd.product.z.applicaiton.service.ProductService;
import me.hoonti06.productordertdd.product.ProductSteps;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PaymentServiceTestV2 {

  @Autowired
  private PaymentServiceV2 paymentService;

  @Autowired
  private OrderServiceV4 orderService;

  @Autowired
  private ProductService productService;

  @Test
  void 상품주문() {
    productService.addProduct(ProductSteps.상품등록요청_생성());
    orderService.createOrder(OrderStepsV4.상품주문요청_생성());

    final PaymentRequest request = PaymentStepsV2.주문결제요청_생성();

    paymentService.payment(request);
  }

}
