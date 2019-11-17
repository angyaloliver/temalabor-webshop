package webshop.model;

import java.util.Collection;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class CustomerName {

  @Id
  @GeneratedValue
  private Integer id;
  private String firstName;
  private String lastName;

  public CustomerName(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }
}
