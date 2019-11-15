package webshop.model;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Delivery {

  @Id
  @GeneratedValue
  private Integer id;

  @OneToOne
  private Address deliveryAddress;

  @OneToOne
  private OrderDetails orderDetails;

  @Enumerated(EnumType.STRING)
  private DeliveryMethod deliveryMethod;

  private LocalDateTime expectedDeliveryDate;
}
