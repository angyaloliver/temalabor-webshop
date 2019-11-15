package webshop.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Address {

  @Id
  @GeneratedValue
  private Integer id;
  private String address;

  @OneToOne
  private Delivery delivery;
  //...
}
