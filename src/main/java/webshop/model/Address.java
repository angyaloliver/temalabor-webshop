package webshop.model;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Address {

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Integer id;
  private String address;

  public Address() {
  }

  public Address(String address){
    this.address = address;
  }

}
