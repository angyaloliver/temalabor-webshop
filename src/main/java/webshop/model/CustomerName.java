package webshop.model;

import java.util.Collection;
import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class CustomerName {

  @Id
  @GeneratedValue(strategy= GenerationType.AUTO)
  private Integer id;
  private String firstName;
  private String lastName;

  public CustomerName() {

  }

  public CustomerName(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }
}
