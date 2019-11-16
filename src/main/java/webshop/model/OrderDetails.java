package webshop.model;

import java.time.LocalDateTime;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class OrderDetails {

  @Id
  @GeneratedValue
  private Integer id;

  private LocalDateTime orderDateTime;

  @OneToOne
  private ShoppingCart shoppingCart;

  @ManyToOne
  @JoinColumn(name = "customer_id")
  private Customer customer;

  @OneToOne
  private Delivery delivery;

  @Enumerated(EnumType.STRING)
  private OrderStatus status;

  @Enumerated(EnumType.STRING)
  private PaymentMethod paymentMethod;

  public OrderDetails() {
  }

  public OrderDetails(int id, LocalDateTime orderDateTime, ShoppingCart shoppingCart, Customer customer,
                      Delivery delivery, OrderStatus status, PaymentMethod paymentMethod) {
    this.id = id;
    this.orderDateTime = orderDateTime;
    this.shoppingCart = shoppingCart;
    this.customer = customer;
    this.delivery = delivery;
    this.status = status;
    this.paymentMethod = paymentMethod;
  }
}
