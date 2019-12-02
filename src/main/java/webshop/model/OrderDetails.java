package webshop.model;

import java.time.LocalDateTime;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
public class OrderDetails {

  @Id
  @GeneratedValue
  private Integer id;

  private LocalDateTime orderDateTime;

  @OneToOne(cascade = {CascadeType.ALL})
  private ShoppingCart shoppingCart;

  @ManyToOne(cascade = {CascadeType.ALL})
  @JoinColumn(name = "customer_id")
  private Customer customer;

  @OneToOne(cascade = {CascadeType.ALL})
  private Delivery delivery;

  @Enumerated(EnumType.STRING)
  private OrderStatus status;

  @Enumerated(EnumType.STRING)
  private PaymentMethod paymentMethod;

  public OrderDetails() {
  }

}
