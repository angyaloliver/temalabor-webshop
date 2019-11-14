package webshop.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Order {

  @Id
  @GeneratedValue
  private Integer id;

  private LocalDateTime orderDateTime;

  @OneToOne
  private ShoppingCart shoppingCart;

  @ManyToOne
  private Customer customer;

  @OneToOne
  private Delivery delivery;

  @Enumerated(EnumType.STRING)
  private OrderStatus status;

  @Enumerated(EnumType.STRING)
  private PaymentMethod paymentMethod;

  public Order() {
  }

  public Order(int id, LocalDateTime orderDateTime, ShoppingCart shoppingCart, Customer customer,
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
