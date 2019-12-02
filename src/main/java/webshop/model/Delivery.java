package webshop.model;

import java.time.LocalDateTime;
import javax.persistence.CascadeType;
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

  @OneToOne(cascade = CascadeType.ALL)
  private Address deliveryAddress;

  @Enumerated(EnumType.STRING)
  private DeliveryMethod deliveryMethod;

  public Delivery() {

  }

  public Delivery(Address deliveryAddress, DeliveryMethod deliveryMethod) {
    this.deliveryAddress = deliveryAddress;
    this.deliveryMethod = deliveryMethod;
  }


  private LocalDateTime expectedDeliveryDate;
}
