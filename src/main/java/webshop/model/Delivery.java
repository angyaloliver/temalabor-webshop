package webshop.model;

import java.time.LocalDateTime;
import javax.persistence.*;

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

  @Enumerated(EnumType.STRING)
  private DeliveryMethod deliveryMethod;

  private LocalDateTime expectedDeliveryDate;
}
