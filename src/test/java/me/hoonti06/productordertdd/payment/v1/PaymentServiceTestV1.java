package me.hoonti06.productordertdd.payment.v1;


import java.util.HashMap;
import java.util.Map;
import me.hoonti06.productordertdd.order.v4.domain.OrderV4;
import me.hoonti06.productordertdd.product.z.domain.DiscountPolicy;
import me.hoonti06.productordertdd.product.z.domain.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

public class PaymentServiceTestV1 {

  private PaymentService paymentService;

  @BeforeEach
  void setUp() {
    final PaymentRepository paymentRepository = new PaymentRepository();
    final PaymentGateway paymentGateway = new ConsolePaymentGateway();
    final PaymentPort paymentPort = new PaymentAdapter(paymentGateway, paymentRepository);
    paymentService = new PaymentService(paymentPort);
  }

  @Test
  void 상품주문() {
    final PaymentRequest request = 주문결제요청_생성();

    paymentService.payment(request);
  }

  private static PaymentRequest 주문결제요청_생성() {
    final Long orderId = 1L;
    final String cardNumber = "1234-1234-1234-1234";
    return new PaymentRequest(orderId, cardNumber);
  }

  private record PaymentRequest(Long orderId, String cardNumber) {
      private PaymentRequest {
        Assert.notNull(orderId, "주문 ID는 필수입니다.");
        Assert.hasText(cardNumber, "카드번호는 필수입니다.");
      }

    }

  private class PaymentService {

    private final PaymentPort paymentPort;

    private PaymentService(PaymentPort paymentPort) {
      this.paymentPort = paymentPort;
    }

    public void payment(PaymentRequest request) {
      OrderV4 order = paymentPort.getOrder(request.orderId());
      final Payment payment = new Payment(order, request.cardNumber());
      paymentPort.pay(payment.getPrice(), payment.getCardNumber());
      paymentPort.save(payment);

    }
  }

  private interface PaymentPort {
    OrderV4 getOrder(Long orderId);

    void pay(int totalPrice, String cardNumber);

    void save(Payment payment);
  }

  public class PaymentAdapter implements PaymentPort {

    private final PaymentGateway paymentGateway;
    private final PaymentRepository paymentRepository;

    public PaymentAdapter(PaymentGateway paymentGateway, PaymentRepository paymentRepository) {
      this.paymentGateway = paymentGateway;
      this.paymentRepository = paymentRepository;
    }

    @Override
    public OrderV4 getOrder(Long orderId) {
      return new OrderV4(new Product("상품1", 1000, DiscountPolicy.NONE), 2);
    }

    @Override
    public void pay(int totalPrice, String cardNumber) {
      paymentGateway.excuete(totalPrice, cardNumber);
    }

    @Override
    public void save(Payment payment) {
      paymentRepository.save(payment);
    }
  }

  private class Payment {

    private Long id;
    private final OrderV4 order;


    private final String cardNumber;

    public Payment(final OrderV4 order, final String cardNumber) {
      Assert.notNull(order, "주문은 필수입니다.");
      Assert.hasText(cardNumber, "카드번호는 필수입니다.");
      this.order = order;
      this.cardNumber = cardNumber;
    }

    public void assignId(long id) {
      this.id = id;
    }

    public Long getId() {
      return this.id;
    }

    public int getPrice() {
      return order.getTotalPrice();
    }

    public String getCardNumber() {
      return cardNumber;
    }
  }


  private interface PaymentGateway {

    void excuete(int totalPrice, String cardNumber);
  }

  private class ConsolePaymentGateway implements PaymentGateway {

    @Override
    public void excuete(int totalPrice, String cardNumber) {
      System.out.println("결제 완료");
    }
  }

  private class PaymentRepository {
    private Map<Long, Payment> persistence = new HashMap<>();
    private long sequence = 0L;

    public void save(Payment payment) {
      payment.assignId(++sequence);
      persistence.put(payment.getId(), payment);
    }
  }
}
