package webshop.model;

import java.time.LocalDateTime;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
