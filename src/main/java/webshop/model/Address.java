package webshop.model;

import javax.persistence.*;

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

  //...
}
