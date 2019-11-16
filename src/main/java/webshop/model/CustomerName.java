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
  @GeneratedValue
  private Integer id;
  private String firstName;
  private String lastName;

  @OneToOne
  private CustomerContact customerContact;

  @ElementCollection(targetClass = Prefix.class)
  private Collection<Prefix> prefixes;
}
